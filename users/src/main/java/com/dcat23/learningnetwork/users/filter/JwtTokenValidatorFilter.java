package com.dcat23.learningnetwork.users.filter;

import com.dcat23.learningnetwork.users.security.JwtTokenGenerator;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.dcat23.learningnetwork.users.security.SecurityConstants.*;

@Slf4j
public class JwtTokenValidatorFilter extends OncePerRequestFilter {

    /**
     * Validates the JWT token present in the request and sets up authentication if the token is valid.
     *
     * @param request The HTTP servlet request
     * @param response The HTTP servlet response
     * @param filterChain The filter chain for executing other filters
     * @throws ServletException If there's an error during the filter execution
     * @throws IOException If there's an I/O error during the filter execution
     *
     * Note: This filter is executed once per request, as it extends OncePerRequestFilter
     */
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = request.getHeader(JWT_HEADER);
        if (jwtToken != null) {
            try {
                Environment env = getEnvironment();
                String secret = env.getProperty(JWT_SECRET_KEY, JWT_SECRET_DEFAULT_VALUE);
                Authentication authentication = JwtTokenGenerator.validateToken(jwtToken, secret);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception exception) {
                throw new BadCredentialsException("Invalid token received", exception);
            }
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getServletPath().equals("/api/users/user");
    }
}
