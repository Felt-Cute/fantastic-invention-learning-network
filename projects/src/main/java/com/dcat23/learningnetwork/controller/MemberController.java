package com.dcat23.learningnetwork.controller;

import com.dcat23.learningnetwork.model.Member;
import com.dcat23.learningnetwork.model.Project;
import com.dcat23.learningnetwork.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/add")
    public ResponseEntity<Member>addMemberToProject(@RequestParam Long projectId,
                                                    @RequestParam Long memberId) {
        Member member = memberService.addMemberToProject(projectId, memberId);
        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Member>removeMemberFromProject(@RequestParam Long projectId,
                                                       @RequestParam Long memberId) {
        memberService.removeMemberFromProject(projectId, memberId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<List<Project>>projects(@PathVariable Long memberId){
        List<Project> projects = memberService.getAllMemberProjects(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(projects);
    }
}
