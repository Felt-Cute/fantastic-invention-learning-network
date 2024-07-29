package com.dcat23.learningnetwork.controller;

import com.dcat23.learningnetwork.dto.ResourceResponse;
import com.dcat23.learningnetwork.dto.ResourceUpdateDTO;
import com.dcat23.learningnetwork.model.Resource;
import com.dcat23.learningnetwork.service.client.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ResourceController {

    private final ResourceService resourceService;

    @GetMapping("/{resourceId}")
    public ResponseEntity<ResourceResponse> getResourceById(@PathVariable Long resourceId){
        ResourceResponse resource = resourceService.getResourceById(resourceId);
        return ResponseEntity.status(HttpStatus.OK).body(resource);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<ResourceResponse>> getResourcesByProject(@PathVariable Long projectId){
        List<ResourceResponse> resources = resourceService.getResourcesByProject(projectId);
        return ResponseEntity.status(HttpStatus.OK).body(resources);
    }

    @PutMapping("/{resourceId}")
    public ResponseEntity<ResourceResponse> updateResource(@PathVariable Long resourceId, @RequestBody ResourceUpdateDTO resourceDTO){
        ResourceResponse resource = resourceService.updateResource(resourceId, resourceDTO);
        return ResponseEntity.status(HttpStatus.OK).body(resource);
    }

    @DeleteMapping("/{resourceId}")
    public ResponseEntity<Void> deleteResource(@PathVariable Long resourceId){
         resourceService.deleteResource(resourceId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
