package com.dcat23.learningnetwork.service;

import com.dcat23.learningnetwork.ProjectRepository;
import com.dcat23.learningnetwork.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MemberServiceImpl implements MemberService {

    private final ProjectRepository projectRepository;
    private final UserServiceClient userServiceClient;

    /**
     * @param projectId the Project id
     * @param memberId  the Member id
     * @return the ADDED Member
     */
    @Override
    public Member addMemberToProject(Long projectId, Long memberId) {
        return null;
    }

    /**
     * @param projectId the Project id
     * @param memberId  the Member id
     * @return the REMOVED Member
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

    /**
     * @param id the Member id
     * @return Member
     */
    @Override
    public Member getMemberById(Long id) {
        Member memberById = userServiceClient.getMemberById(id);
        return memberById;
    }
}
