package com.miguelpazo.game.filters;

import com.miguelpazo.game.dto.JwtPayload;
import com.miguelpazo.game.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Miguel Pazo (https://miguelpazo.com)
 */
@Component
public class ApiFilter extends GenericFilterBean {

    @Autowired
    private JwtService jwtService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String auth = httpRequest.getHeader("Authorization");
        String first = "Bearer";

        try {
            if (auth != null) {
                if (auth.indexOf(first) == 0) {
                    String jwtToken = auth.substring(first.length() + 1);
                    JwtPayload jwtPayload = jwtService.validate(jwtToken);

                    if (jwtPayload != null) {
                        request.setAttribute("jwtPayload", jwtPayload);
                        chain.doFilter(request, response);
                        return;
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex);
        }

        httpResponse.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }
}
