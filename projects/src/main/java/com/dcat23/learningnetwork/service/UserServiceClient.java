package com.dcat23.learningnetwork.service;

import com.dcat23.learningnetwork.model.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "${service.user.url}")
public interface UserServiceClient {

    @GetMapping("/api/users/{id}")
    Member getMemberById(@PathVariable("id") Long id);
}
