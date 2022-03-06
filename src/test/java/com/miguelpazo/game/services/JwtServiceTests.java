package com.miguelpazo.game.services;

import com.miguelpazo.game.dto.JwtPayload;
import com.miguelpazo.game.services.interfaces.IJwtService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@SpringBootTest
class JwtServiceTests {

    private static final Logger logger = LoggerFactory.getLogger(JwtServiceTests.class);

    @Autowired
    private IJwtService jwtService;

    @BeforeAll
    public static void prepare() {
        /**
         * TODO
         */
    }

    @Test
    public void validateTest() {
        try {
            String jwtToken = "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJtaWd1ZWwiLCJleHAiOjE2NDY1OTUxMTAsImF1ZCI6IkFMTCIsImp0aSI6IlhFUkh5UGstbGM3QU1jMFFBNldGMHciLCJpYXQiOjE2NDY1OTE1MTAsInN1YiI6IkFVVEhUT0tFTiIsImVtYWlsIjoibWlndWVsLnBzMTlAZ21haWwuY29tIn0.WlKlSUjkKNoUpcHq_iO_Yo1kdJHFVC6d44E0YsxiVPU1ANQZdQ_ZQjwxfjJ7FyXJskrJ8fxlH3Mb2bhB0vtun-MqHWUtnge0wAIKiOkl8GYcEJ_M9BvMshnJttL2kv6brpC-pbavcHqtADRL-XVB9ptchExuPnkYW4JdZihyZIIOWdSXAW3l3zEsl05ZRkq1Syl3mkA1_ZfxzhVVqn2oVlAmvoa7a8IBym7E-F_d1WiPbc69WH0eCNsBsyOHKBhySqzEXqHlvI8qoXZxq6GwRGfcbSkK0sn-5URhikNLovlJMXtrSqXVvu8_5BT6zvUeXISg7Vrqq1ia6qJdc7tx2g";
            JwtPayload result = jwtService.validate(jwtToken);

            logger.info(result.toString());

            assertThat(result)
                    .isNotEqualTo(null);
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            logger.error(sw.toString());
        }
    }
}
