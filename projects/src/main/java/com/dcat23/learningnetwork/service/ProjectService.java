package com.dcat23.learningnetwork.service;

import com.dcat23.learningnetwork.dto.ProjectCreationDTO;
import com.dcat23.learningnetwork.dto.ProjectResponse;
import com.dcat23.learningnetwork.dto.ProjectUpdateDTO;

import java.util.List;

public interface ProjectService {
    ProjectResponse getProjectWithDetails(Long id);

    ProjectResponse createProject(ProjectCreationDTO projectDTO);

    ProjectResponse updateProject(Long id, ProjectUpdateDTO projectDTO);

    void deleteProject(Long id);

    List<ProjectResponse> getAllProjects();
}
