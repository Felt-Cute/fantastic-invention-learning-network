package com.dcat23.learningnetwork.service;

import com.dcat23.learningnetwork.exception.ProjectNotFoundException;
import com.dcat23.learningnetwork.model.Project;
import com.dcat23.learningnetwork.repository.ProjectRepository;
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
     */
    @Override
    public void removeMemberFromProject(Long projectId, Long memberId) {
        Project project = findProjectById(projectId);
        project.getMemberIds().remove(memberId);
    }

    private Project findProjectById(Long projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
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
