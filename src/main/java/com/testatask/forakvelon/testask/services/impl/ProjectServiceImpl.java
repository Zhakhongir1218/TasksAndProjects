package com.testatask.forakvelon.testask.services.impl;

import com.testatask.forakvelon.testask.exceptions.ProjectIsNullException;
import com.testatask.forakvelon.testask.mappers.ProjectMapper;
import com.testatask.forakvelon.testask.models.dtos.ProjectDTO;
import com.testatask.forakvelon.testask.models.entities.Project;
import com.testatask.forakvelon.testask.models.enums.ProjectStatus;
import com.testatask.forakvelon.testask.repositories.ProjectRepo;
import com.testatask.forakvelon.testask.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
/*
* In this class, we implement the business logic of tasks
* */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepo projectRepo;


    // First method that should be used is creating new project
    @Override
    public ResponseEntity<?> createNewProject(ProjectDTO projectDTO) throws ProjectIsNullException {
        Project project = ProjectMapper.INSTANCE.toProject(projectDTO);
        if(Objects.isNull(project)){
            throw new ProjectIsNullException("Project is null"," the fields are empty ");
        }
        if(project.getPriority()>10||project.getPriority()<=0){
            throw new ProjectIsNullException("Priority error"," the priority can not be lower than 1 and higher than 10");
        }
        if(project.getStart_date().isAfter(project.getEnd_date())){
            throw new ProjectIsNullException("Date time ERROR", " end date can't stand before than start date");
        }
        project.setProjectStatus(ProjectStatus.NOT_STARTED);
        projectRepo.save(project);
        return ResponseEntity.ok("Success");
    }

    //Update status is quite simple but very useful and in my opinion is something like a heart in our business logic
    //cause the main reason to interact user with this program is to change status during the working time
    @Override
    public ResponseEntity<?> updateStatus(Long id, ProjectStatus projectStatus) throws ProjectIsNullException {
        Project project = projectRepo.getById(id);
        if(Objects.isNull(project)){
            throw new ProjectIsNullException("Project not found", "Try to enter another id");
        }


        project.setProjectStatus(projectStatus);
        projectRepo.save(project);
        return ResponseEntity.ok("Success");
    }
    //Actually the "update project" method is not that user-friendly as it can be(cause of ProjectDTO),
    // but it's work and does everything that should do.
    //For more information about this method you can contact me : zhakhongir1218@gmail.com

    @Override
    public ResponseEntity<?> updateProject(ProjectDTO projectDTO) throws ProjectIsNullException {
        Project project = ProjectMapper.INSTANCE.toProject(projectDTO);
        project = projectRepo.findDistinctById(project.getId());
        if(Objects.isNull(project)){
            throw new ProjectIsNullException("Project not found", " input existing project or create a new one");
        }
        if(project.getPriority()>10||project.getPriority()<=0){
            throw new ProjectIsNullException("Priority error"," the priority can not be lower than 1 and higher than 10");
        }
        if(project.getStart_date().isAfter(project.getEnd_date())){
            throw new ProjectIsNullException("Date time ERROR", " end date can't stand before than start date");
        }
        project = ProjectMapper.INSTANCE.toProject(projectDTO);
        projectRepo.save(project);


        return ResponseEntity.ok("Success, you have updated this project");
    }


    //I thought to add new field to ENUM ProjectStatus (new field = DELETED) for keep the history in the DataBase
    //But I decided to follow the technical task
    @Override
    public ResponseEntity<?> deleteProject(Long id) throws ProjectIsNullException {

        Project project = projectRepo.findDistinctById(id);

        if(Objects.isNull(project)){
            throw new ProjectIsNullException("Project is null", " enter correct id please");
        }
        if(project.getProjectStatus().equals(ProjectStatus.ACTIVE)){
            throw new ProjectIsNullException("The project is active", "project is active, you can't delete it");
        }
        projectRepo.delete(project);

        return ResponseEntity.ok("You have deleted " + project.getName() + " project");
    }
    //Simple method that gets all projects
    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepo.findAll();
        List<ProjectDTO> projectDTOS = new ArrayList<>();
        for(Project p : projects ){
            projectDTOS.add(ProjectMapper.INSTANCE.toProjectDTO(p));
        }
        return projectDTOS;
    }
    //Method is getting all projects and sorting them by priority desc
    //Highest priority will be at top
    @Override
    public List<ProjectDTO> getSortedByPriority(){
        List<ProjectDTO> projectDTOS = getAllProjects();
        return projectDTOS.stream()
                .sorted(Comparator.comparing(ProjectDTO::getPriority).reversed())
                .collect(Collectors.toList());
    }




}
