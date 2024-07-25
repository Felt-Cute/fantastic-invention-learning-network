package com.dcat23.learningnetwork.service;

import com.dcat23.learningnetwork.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    /**
     * @param projectId the Project id
     * @param memberId  the Member's id
     * @return the ADDED Member
     */
    @Override
    public Member addMemberToProject(Long projectId, Long memberId) {
        return null;
    }

    /**
     * @param projectId the Project id
     * @param memberId  the Member's id
     * @return the removed Member
     */
    @Override
    public Member removeMemberFromProject(Long projectId, Long memberId) {
        return null;
    }

    /**
     * @param memberId the Member id
     * @return list of Projects associated to a Member id
     */
    @Override
    public List<Member> getAllMemberProjects(Long memberId) {
        return List.of();
    }
}
