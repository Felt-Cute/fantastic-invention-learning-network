package com.dcat23.learningnetwork.repository;

import com.dcat23.learningnetwork.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByMemberIdsContaining(Long memberId);
}
