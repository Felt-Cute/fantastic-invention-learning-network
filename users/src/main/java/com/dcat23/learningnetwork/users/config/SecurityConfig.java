package com.dcat23.learningnetwork.users.config;

import com.dcat23.learningnetwork.users.exception.GlobalAccessDeniedHandler;
import com.dcat23.learningnetwork.users.exception.GlobalAuthenticationEntryPoint;
import com.dcat23.learningnetwork.users.filter.JwtTokenGeneratorFilter;
import com.dcat23.learningnetwork.users.filter.JwtTokenValidatorFilter;
import com.dcat23.learningnetwork.users.model.Role;
import com.dcat23.learningnetwork.users.security.CorsConfigurationSourceImpl;
import com.dcat23.learningnetwork.users.security.UsernamePwdAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableMethodSecurity
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
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**",
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
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService) throws Exception
    {
        UsernamePwdAuthenticationProvider authProvider =
                new UsernamePwdAuthenticationProvider(userDetailsService);
        ProviderManager providerManager = new ProviderManager(authProvider);
        providerManager.setEraseCredentialsAfterAuthentication(false);
        return providerManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
