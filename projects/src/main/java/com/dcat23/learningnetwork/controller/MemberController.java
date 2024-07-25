package com.dcat23.learningnetwork.controller;

import com.dcat23.learningnetwork.model.Member;
import com.dcat23.learningnetwork.model.Project;
import com.dcat23.learningnetwork.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
    name = "REST APIs for Project Members",
    description = "REST APIs to ADD and REMOVE Project Members")
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/add")
    @Operation(
            summary = "Add Member To Project",
            description = "REST API to add a Member to project")
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED")
    public ResponseEntity<Member>addMemberToProject(@RequestParam Long projectId,
                                                    @RequestParam Long memberId) {
        Member member = memberService.addMemberToProject(projectId, memberId);
        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    @DeleteMapping("/remove")
    @Operation(
            summary = "Remove Member From Project",
            description = "REST API to remove a Member from a Project")
    @ApiResponse(
            responseCode = "204",
            description = "HTTP Status NO CONTENT")
    public ResponseEntity<Member>removeMemberFromProject(@RequestParam Long projectId,
                                                       @RequestParam Long memberId) {
        memberService.removeMemberFromProject(projectId, memberId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{memberId}")
    @Operation(
            summary = "Projects",
            description = "REST API to list all Projects associated to a member id")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK")
    public ResponseEntity<List<Project>>projects(@PathVariable Long memberId){
        List<Project> projects = memberService.getAllMemberProjects(memberId);
        return ResponseEntity.status(HttpStatus.OK).body(projects);
    }
}
