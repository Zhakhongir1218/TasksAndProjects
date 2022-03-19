package com.testatask.forakvelon.testask.controllers;

import com.testatask.forakvelon.testask.exceptions.ProjectIsNullException;
import com.testatask.forakvelon.testask.models.dtos.ProjectDTO;
import com.testatask.forakvelon.testask.models.enums.ProjectStatus;
import com.testatask.forakvelon.testask.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewProject(@RequestBody ProjectDTO projectDTO) throws ProjectIsNullException {
        return projectService.createNewProject(projectDTO);
    }

    @PostMapping("/status")
    public ResponseEntity<?> updateProjectStatus(@RequestParam Long id, @RequestParam ProjectStatus projectStatus) throws ProjectIsNullException {
        return projectService.updateStatus(id, projectStatus);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateProject(@RequestBody ProjectDTO projectDTO) throws ProjectIsNullException {
        return projectService.updateProject(projectDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProject(@RequestParam Long id) throws ProjectIsNullException {
        return projectService.deleteProject(id);
    }

    @GetMapping("/getall")
    public List<ProjectDTO> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("/sort/priority")
    public List<ProjectDTO> getAllSortedByPriority(){
        return projectService.getSortedByPriority();
    }


}
