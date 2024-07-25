package com.dcat23.learningnetwork.controller;

import com.dcat23.learningnetwork.dto.ProjectCreationDTO;
import com.dcat23.learningnetwork.dto.ProjectResponse;
import com.dcat23.learningnetwork.dto.ProjectUpdateDTO;
import com.dcat23.learningnetwork.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ProjectController {

    private final ProjectService projectService;

    @Operation(
            summary = "Get Project by id",
            description = "REST API to FETCH Project by id")
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse>getProject(@PathVariable Long id){
        ProjectResponse project = projectService.getProjectWithDetails(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }


    @GetMapping("")
    @Operation(
            summary = "Get All Projects",
            description = "REST API to FETCH all projects")
    public ResponseEntity<List<ProjectResponse>> getAllProjects(){
        List<ProjectResponse> projects = projectService.getAllProjects();
        return ResponseEntity.status(HttpStatus.OK).body(projects);
    }

    @PostMapping
    @Operation(
            summary = "Create Project",
            description = "REST API to create a new Project")
    public ResponseEntity<ProjectResponse> createProject(@Valid @RequestBody ProjectCreationDTO projectDTO){
        ProjectResponse createdProject = projectService.createProject(projectDTO);
        return ResponseEntity.status(HttpStatus.OK).body(createdProject);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update Project",
            description = "REST API to update an existing project")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id, @RequestBody ProjectUpdateDTO projectDTO){
        ProjectResponse updatedProject = projectService.updateProject(id, projectDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProject);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete Project",
            description = "REST API to DELETE a Project")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }


}
