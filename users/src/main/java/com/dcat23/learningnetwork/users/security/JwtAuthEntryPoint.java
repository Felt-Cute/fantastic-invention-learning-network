package com.dcat23.learningnetwork.users.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {

    /**
     * Handles the authentication error by sending an unauthorized error response.
     *
     * @param request       the HttpServletRequest object that contains the request the client has made to the servlet
     * @param response      the HttpServletResponse object that contains the response the servlet sends to the client
     * @param authException the AuthenticationException that indicates an authentication error
     * @throws IOException      if an input or output error occurs while the servlet is handling the request
     * @throws ServletException if the request could not be handled
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
    }
}
