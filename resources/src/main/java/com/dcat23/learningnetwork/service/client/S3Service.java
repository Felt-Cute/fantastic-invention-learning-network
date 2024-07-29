package com.dcat23.learningnetwork.service.client;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
    String upload(MultipartFile file);
}
