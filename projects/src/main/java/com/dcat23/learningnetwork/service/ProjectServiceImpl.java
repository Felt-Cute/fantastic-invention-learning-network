package com.dcat23.learningnetwork.service;

import com.dcat23.learningnetwork.dto.ProjectCreationDTO;
import com.dcat23.learningnetwork.dto.ProjectResponse;
import com.dcat23.learningnetwork.dto.ProjectUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    /**
     * @param id the projectId
     * @return the Project
     */
    @Override
    public ProjectResponse getProjectWithDetails(Long id) {
        return null;
    }

    /**
     * @param projectDTO initial details about the Project
     * @return the new Project
     */
    @Override
    public ProjectResponse createProject(ProjectCreationDTO projectDTO) {
        return null;
    }

    /**
     * @param id         the projectId
     * @param projectDTO the updated Project details
     * @return the updated Project
     */
    @Override
    public ProjectResponse updateProject(Long id, ProjectUpdateDTO projectDTO) {
        return null;
    }

    /**
     * @param id the projectId
     */
    @Override
    public void deleteProject(Long id) {

    }

    /**
     * @return list of all Projects
     */
    @Override
    public List<ProjectResponse> getAllProjects() {
        return List.of();
    }
}
