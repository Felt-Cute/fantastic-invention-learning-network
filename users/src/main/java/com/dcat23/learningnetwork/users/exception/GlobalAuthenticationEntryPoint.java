package com.dcat23.learningnetwork.users.exception;

import com.dcat23.mapper.ErrorMessageMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class GlobalAuthenticationEntryPoint implements AuthenticationEntryPoint {

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
        String path = request.getRequestURI();
        String message = (authException.getMessage() != null) ? authException.getMessage() : "Unauthorized";
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=utf-8");
        response.setHeader("filn-error-reason", "Authentication Failed");
        String json = ErrorMessageMapper.mapToJson(message, path, HttpStatus.UNAUTHORIZED);
        response.getWriter().write(json);
    }

}
