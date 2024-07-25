package com.dcat23.learningnetwork.users.config;

import com.dcat23.learningnetwork.users.exception.GlobalAccessDeniedHandler;
import com.dcat23.learningnetwork.users.exception.GlobalAuthenticationEntryPoint;
import com.dcat23.learningnetwork.users.filter.JwtTokenGeneratorFilter;
import com.dcat23.learningnetwork.users.filter.JwtTokenValidatorFilter;
import com.dcat23.learningnetwork.users.security.CorsConfigurationSourceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(
                                "/api/users/user"
                        ).authenticated()
                        .requestMatchers(
                                "/error",
                                "/api/users/login",
                                "/api/users/register")
                        .permitAll()
                        .anyRequest().authenticated());

        http.cors(corsConfig -> corsConfig.configurationSource(new CorsConfigurationSourceImpl()));
        http.csrf(AbstractHttpConfigurer::disable);
        http.httpBasic(hbc -> hbc.authenticationEntryPoint(new GlobalAuthenticationEntryPoint()));
        http.formLogin(AbstractHttpConfigurer::disable);
        http.exceptionHandling(handler -> handler
                .authenticationEntryPoint(new GlobalAuthenticationEntryPoint())
                .accessDeniedHandler(new GlobalAccessDeniedHandler())
        );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
