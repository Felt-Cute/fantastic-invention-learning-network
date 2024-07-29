package com.dcat23.learningnetwork.service.impl;

import com.dcat23.learningnetwork.service.client.S3Service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class S3ServiceImpl implements S3Service {

    /**
     * @param file MultipartFile to upload
     * @return the url of the file in S3 bucket
     */
    @Override
    public String upload(MultipartFile file) {
        return "NOT IMPLEMENTED";
    }
}
