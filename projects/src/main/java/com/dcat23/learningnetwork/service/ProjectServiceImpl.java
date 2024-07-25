package com.dcat23.learningnetwork.service;

import com.dcat23.learningnetwork.repository.ProjectRepository;
import com.dcat23.learningnetwork.dto.ProjectCreationDTO;
import com.dcat23.learningnetwork.dto.ProjectResponse;
import com.dcat23.learningnetwork.dto.ProjectUpdateDTO;
import com.dcat23.learningnetwork.exception.ProjectNotFoundException;
import com.dcat23.learningnetwork.mapper.ProjectMapper;
import com.dcat23.learningnetwork.model.Member;
import com.dcat23.learningnetwork.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserServiceClient userServiceClient;

    /**
     * @param id the projectId
     * @return the Project
     */
    @Override
    public ProjectResponse getProjectWithDetails(Long id) {
        Project project = findById(id);
        return ProjectMapper.mapToProjectResponse(project);
    }

    private Project findById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    /**
     * @param projectDTO initial details about the Project
     * @return the new Project
     */
    @Override
    public ProjectResponse createProject(ProjectCreationDTO projectDTO) {
        Project project = ProjectMapper.mapFromProjectCreationDTO(projectDTO);
        Member owner = userServiceClient.getMemberById(projectDTO.ownerId());
        project.setOwnerId(owner.id());
        Project saved = projectRepository.save(project);
        return ProjectMapper.mapToProjectResponse(saved);
    }

    /**
     * @param id         the projectId
     * @param projectDTO the updated Project details
     * @return the updated Project
     */
    @Override
    public ProjectResponse updateProject(Long id, ProjectUpdateDTO projectDTO) {
        Project project = findById(id);
        updateOwner(project, projectDTO);
        ProjectMapper.mapFromProjectUpdateDTO(projectDTO, project);
        Project saved = projectRepository.save(project);
        return ProjectMapper.mapToProjectResponse(saved);
    }

    private void updateOwner(Project project, ProjectUpdateDTO projectDTO) {
        if (projectDTO.ownerId() == null) return;
        if (!Objects.equals(project.getOwnerId(), projectDTO.ownerId())) {
            Member memberById = userServiceClient.getMemberById(projectDTO.ownerId());
            if (memberById != null) {
                project.setOwnerId(memberById.id());
            }
        }

    }

    /**
     * @param id the projectId
     */
    @Override
    public void deleteProject(Long id) {
        Project project = findById(id);
        projectRepository.delete(project);
    }

    /**
     * @return list of all Projects
     */
    @Override
    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll().stream()
                .map(ProjectMapper::mapToProjectResponse)
                .toList();
    }
}
