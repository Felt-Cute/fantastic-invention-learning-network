package com.dcat23.learningnetwork.service;

import com.dcat23.learningnetwork.model.Member;
import com.dcat23.learningnetwork.model.Project;

import java.util.List;

public interface MemberService {
    Member addMemberToProject(Long projectId, Long memberId);

    void removeMemberFromProject(Long projectId, Long memberId);

    List<Project> getAllMemberProjects(Long memberId);
}
