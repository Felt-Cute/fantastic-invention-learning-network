package com.dcat23.learningnetwork.service;

import com.dcat23.learningnetwork.model.Member;

import java.util.List;

public interface MemberService {
    Member addMemberToProject(Long projectId, Long memberId);

    Member removeMemberFromProject(Long projectId, Long memberId);

    List<Member> getAllMemberProjects(Long memberId);
}
