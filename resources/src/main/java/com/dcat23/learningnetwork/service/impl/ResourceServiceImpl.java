package com.dcat23.learningnetwork.service.impl;

import com.dcat23.learningnetwork.ResourceRepository;
import com.dcat23.learningnetwork.dto.ResourceResponse;
import com.dcat23.learningnetwork.dto.ResourceUpdateDTO;
import com.dcat23.learningnetwork.dto.ResourceUploadDTO;
import com.dcat23.learningnetwork.exception.ResourceNotFoundException;
import com.dcat23.learningnetwork.mapper.ResourceMapper;
import com.dcat23.learningnetwork.model.Resource;
import com.dcat23.learningnetwork.service.client.ResourceService;
import com.dcat23.learningnetwork.service.client.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper = ResourceMapper.INSTANCE;
    private final S3Service s3Service;

    /**
     * @param resourceId the id of the Resource entity
     * @return ResourceResponse
     */
    @Override
    public ResourceResponse getResourceById(Long resourceId) {
        Resource resource = findResourceById(resourceId);
        return resourceMapper.map(resource);
    }

    private Resource findResourceById(Long resourceId) {
        return resourceRepository.findById(resourceId)
                .orElseThrow(() -> new ResourceNotFoundException(resourceId));
    }

    /**
     * @param projectId the Project id associated to the resource
     * @return List of ResourceResponse objects
     */
    @Override
    public List<ResourceResponse> getResourcesByProject(Long projectId) {
        List<Resource> resources = resourceRepository.findByProjectId(projectId);
        return resourceMapper.map(resources);
    }

    /**
     * @param resourceId the id of the Resource entity
     * @param resourceDTO ResourceDTO
     * @return ResourceResponse
     */
    @Override
    public ResourceResponse updateResource(Long resourceId, ResourceUpdateDTO resourceDTO) {
        Resource resource = findResourceById(resourceId);
        resourceMapper.update(resourceDTO, resource);
        Resource saved = resourceRepository.save(resource);
        return resourceMapper.map(saved);
    }

    /**
     * @param resourceId the id of the Resource entity
     */
    @Override
    public void deleteResource(Long resourceId) {
        Resource resourceById = findResourceById(resourceId);
        resourceRepository.delete(resourceById);
    }

    /**
     * @param resourceUploadDTO ResourceUploadDTO details
     * @return ResourceResponse
     */
    @Override
    public ResourceResponse uploadResource(ResourceUploadDTO resourceUploadDTO) {
        String fileUrl = s3Service.upload(resourceUploadDTO.file());
        Resource resource = resourceMapper.map(resourceUploadDTO);
        resource.setFileUrl(fileUrl);
        Resource saved = resourceRepository.save(resource);
        return resourceMapper.map(saved);
    }
}
