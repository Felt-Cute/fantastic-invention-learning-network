package com.dcat23.learningnetwork.users.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

import static com.dcat23.learningnetwork.users.security.SecurityConstants.*;

public class JwtTokenGenerator {

    public static String generateToken(Authentication auth, String jwtSecret) {
        SecretKey secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder().issuer(JWT_ISSUER).subject(auth.getName())
                .claim(JWT_USERNAME_KEY, auth.getName())
                .claim(JWT_AUTHORITY_KEY, extractAuthorities(auth))
                .issuedAt(new Date())
                .expiration(expiration())
                .signWith(secretKey).compact();
    }

    private static Date expiration() {
        long nowMillis = System.currentTimeMillis();
        return new Date(nowMillis + JWT_TOKEN_EXPIRATION);
    }

    private static String extractAuthorities(Authentication auth) {
        return auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }
}

