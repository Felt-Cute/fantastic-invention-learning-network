package com.dcat23.learningnetwork.repository;

import com.dcat23.learningnetwork.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findByProjectId(Long projectId);
}
