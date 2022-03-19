package com.testatask.forakvelon.testask.services;

import com.testatask.forakvelon.testask.exceptions.ProjectIsNullException;
import com.testatask.forakvelon.testask.models.dtos.ProjectDTO;
import com.testatask.forakvelon.testask.models.enums.ProjectStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjectService {
    ResponseEntity<?> createNewProject(ProjectDTO projectDTO) throws ProjectIsNullException;

    ResponseEntity<?> updateStatus(Long id, ProjectStatus projectStatus) throws ProjectIsNullException;

    ResponseEntity<?> updateProject(ProjectDTO projectDTO) throws ProjectIsNullException;

    ResponseEntity<?> deleteProject(Long id) throws ProjectIsNullException;

    List<ProjectDTO> getAllProjects();

    List<ProjectDTO> getSortedByPriority();
}
