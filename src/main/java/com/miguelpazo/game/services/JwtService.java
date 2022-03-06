package com.miguelpazo.game.services;

import com.google.gson.Gson;
import com.miguelpazo.game.common.Utils;
import com.miguelpazo.game.dto.JwtPayload;
import com.miguelpazo.game.services.interfaces.IJwtService;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.InvalidJwtSignatureException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@Service
public class JwtService implements IJwtService {

    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

    @Value("${auth.jwt.issuer}")
    private String issuer;
    @Autowired
    private Utils utils;

    @Override
    public JwtPayload validate(String jwtToken) {
        try {
            String keyData = utils.readFileFromResources("/keys/auth_public.json");
            RsaJsonWebKey jsonWebKey = (RsaJsonWebKey) JsonWebKey.Factory.newJwk(keyData);

            JwtConsumer jwtConsumer = new JwtConsumerBuilder()
                    .setRequireExpirationTime()
                    .setRequireSubject()
                    .setExpectedIssuer(issuer)
                    .setExpectedAudience("ALL")
                    .setVerificationKey(jsonWebKey.getPublicKey())
                    .setRelaxVerificationKeyValidation()
                    .build();

            JwtClaims claims = jwtConsumer.processToClaims(jwtToken);

            if (NumericDate.now().getValue() < claims.getExpirationTime().getValue()) {
                Gson g = new Gson();
                return g.fromJson(claims.getRawJson(), JwtPayload.class);
            }
        } catch (InvalidJwtSignatureException ex) {
            logger.error("Invalid signature");
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }

        return null;
    }
}

