package com.dcat23.learningnetwork.controller;

import com.dcat23.learningnetwork.dto.ProjectCreationDTO;
import com.dcat23.learningnetwork.dto.ProjectResponse;
import com.dcat23.learningnetwork.dto.ProjectUpdateDTO;
import com.dcat23.learningnetwork.service.ProjectService;
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

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse>getProject(@PathVariable Long id){
        ProjectResponse project = projectService.getProjectWithDetails(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);
    }

    @GetMapping("")
    public ResponseEntity<List<ProjectResponse>> getAllProjects(){
        List<ProjectResponse> projects = projectService.getAllProjects();
        return ResponseEntity.status(HttpStatus.OK).body(projects);
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@Valid @RequestBody ProjectCreationDTO projectDTO){
        ProjectResponse createdProject = projectService.createProject(projectDTO);
        return ResponseEntity.status(HttpStatus.OK).body(createdProject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id, @RequestBody ProjectUpdateDTO projectDTO){
        ProjectResponse updatedProject = projectService.updateProject(id, projectDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }


}
