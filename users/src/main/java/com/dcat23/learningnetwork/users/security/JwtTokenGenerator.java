package com.dcat23.learningnetwork.users.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtTokenGenerator {

    private static final String JWT_ISSUER = "Fantastic Invention";
    private static final String JWT_USERNAME_KEY = "username";
    private static final String JWT_AUTHORITY_KEY = "authorities";
    private static final long JWT_TOKEN_EXPIRATION = 1000 * 60 * 60 * 10; // 10 hours

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

    public static Authentication validateToken(String token, String jwtSecret) {
        SecretKey secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
        Claims claims = Jwts.parser().verifyWith(secretKey).build()
                .parseSignedClaims(token).getPayload();
        String username = String.valueOf(claims.get(JWT_USERNAME_KEY));
        String authorities = String.valueOf(claims.get(JWT_AUTHORITY_KEY));
        return new UsernamePasswordAuthenticationToken(username, null,
                AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
    }
}

