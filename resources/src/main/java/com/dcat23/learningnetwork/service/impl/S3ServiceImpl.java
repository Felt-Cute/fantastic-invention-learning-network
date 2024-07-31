package com.dcat23.learningnetwork.service.impl;

import com.dcat23.learningnetwork.service.client.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class S3ServiceImpl implements S3Service {

    @Value("${aws.s3.buckets.filn}")
    private String bucketName;

    private final S3Client s3Client;

    /**
     * @param file MultipartFile to upload
     * @return the url of the file in S3 bucket
     */
    @Override
    public String upload(MultipartFile file) throws IOException {
        String key = generateKey(file);
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .build();

        s3Client.putObject(
                putObjectRequest,
                RequestBody.fromBytes(file.getBytes()));

        log.info("Uploaded {} to bucket {}", key, bucketName);
        return constructFileUrl(bucketName, key);
    }

    private String generateKey(MultipartFile file) {
        return UUID.randomUUID() + "-" + file.getOriginalFilename();
    }

    private String constructFileUrl(String bucketName, String key) {
        return String.format("https://%s.s3.amazonaws.com/%s", bucketName, key);
    }
}
