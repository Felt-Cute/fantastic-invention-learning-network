package com.dcat23.learningnetwork.dto;

import org.springframework.web.multipart.MultipartFile;

public record ResourceUploadDTO(
        MultipartFile file,
        String title,
        Long projectId,
        Long userId
) {
}
