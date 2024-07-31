package com.dcat23.learningnetwork.service.client;

import com.dcat23.learningnetwork.dto.ResourceUploadDTO;
import com.dcat23.learningnetwork.dto.ResourceResponse;
import com.dcat23.learningnetwork.dto.ResourceUpdateDTO;

import java.util.List;

public interface ResourceService {
    ResourceResponse getResourceById(Long resourceId);

    List<ResourceResponse> getResourcesByProject(Long projectId);

    ResourceResponse updateResource(Long resourceId, ResourceUpdateDTO resourceDTO);

    void deleteResource(Long resourceId);

    ResourceResponse uploadResource(ResourceUploadDTO resourceUploadDTO);
}
