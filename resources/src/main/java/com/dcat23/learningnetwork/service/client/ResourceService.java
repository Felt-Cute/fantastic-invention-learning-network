package com.dcat23.learningnetwork.service.client;

import com.dcat23.learningnetwork.dto.ResourceDTO;
import com.dcat23.learningnetwork.dto.ResourceResponse;

import java.util.List;

public interface ResourceService {
    ResourceResponse getResourceById(Long resourceId);

    List<ResourceResponse> getResourcesByProject(Long projectId);

    ResourceResponse updateResource(Long resourceId, ResourceDTO resourceDTO);

    void deleteResource(Long resourceId);
}
