package com.dcat23.learningnetwork.security;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AuthInterceptor implements RequestInterceptor {

    private final JwtToken jwtToken;

    /**
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {

    }
}
