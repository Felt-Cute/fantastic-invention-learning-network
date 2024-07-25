package com.dcat23.learningnetwork;

import com.dcat23.learningnetwork.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
