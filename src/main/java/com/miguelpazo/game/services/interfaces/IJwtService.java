package com.miguelpazo.game.services.interfaces;

import com.miguelpazo.game.dto.JwtPayload;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
public interface IJwtService {

    JwtPayload validate(String jwtToken);
}
