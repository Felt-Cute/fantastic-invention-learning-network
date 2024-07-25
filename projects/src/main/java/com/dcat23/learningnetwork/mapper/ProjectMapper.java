package com.dcat23.learningnetwork.mapper;

import com.dcat23.learningnetwork.dto.ProjectCreationDTO;
import com.dcat23.learningnetwork.dto.ProjectResponse;
import com.dcat23.learningnetwork.dto.ProjectUpdateDTO;
import com.dcat23.learningnetwork.model.Project;

public class ProjectMapper {
    public static ProjectResponse mapToProjectResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getOwnerId(),
                project.getMemberIds()
        );
    }

    public static Project mapFromProjectCreationDTO(ProjectCreationDTO projectDTO) {
        Project project = new Project();
        project.setTitle(projectDTO.title());
        project.setDescription(projectDTO.description());
        return project;
    }

    public static void mapFromProjectUpdateDTO(ProjectUpdateDTO projectDTO, Project project) {
        if (project == null || projectDTO == null) return;

        if (projectDTO.title() != null) {
            project.setTitle(projectDTO.title());
        }
        if (projectDTO.description() != null) {
            project.setDescription(projectDTO.description());
        }

    }
}
