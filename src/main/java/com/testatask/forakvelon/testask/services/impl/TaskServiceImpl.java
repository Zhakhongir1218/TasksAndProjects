package com.testatask.forakvelon.testask.services.impl;

import com.testatask.forakvelon.testask.exceptions.ProjectIsNullException;
import com.testatask.forakvelon.testask.exceptions.TaskIsNullExeption;
import com.testatask.forakvelon.testask.mappers.ProjectMapper;
import com.testatask.forakvelon.testask.mappers.TaskMapper;
import com.testatask.forakvelon.testask.models.dtos.TaskDTO;
import com.testatask.forakvelon.testask.models.entities.Task;
import com.testatask.forakvelon.testask.models.enums.TaskStatus;
import com.testatask.forakvelon.testask.repositories.TaskRepo;
import com.testatask.forakvelon.testask.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepo taskRepo;

    @Override
    public ResponseEntity<?> createNewTask(TaskDTO taskDTO) throws TaskIsNullExeption, ProjectIsNullException {
        if(Objects.isNull(taskDTO)){
            throw new TaskIsNullExeption("ERROR","the fields are empty");
        }
        if(taskDTO.getEndDate().isBefore(taskDTO.getStartDate())){
            throw new TaskIsNullExeption("ERROR", "the end date can not be earlier than start date");
        }
        if(taskDTO.getPriority()>10 || taskDTO.getPriority()<=0){
            throw new TaskIsNullExeption("ERROR", "The min range of priority is 1 and the max range is 10");
        }

        if(Objects.isNull(taskDTO.getProjectDTO())){
            throw new ProjectIsNullException("ERROR", "The task has to belong to the project");
        }
        taskDTO.setTaskStatus(TaskStatus.TO_DO);
        Task task = TaskMapper.INSTANCE.toTask(taskDTO);
        task.setProject(ProjectMapper.INSTANCE.toProject(taskDTO.getProjectDTO()));
        taskRepo.save(task);

        return ResponseEntity.ok("Success");
    }

    @Override
    public ResponseEntity<?> updateTaskStatus(Long id, TaskStatus taskStatus) throws TaskIsNullExeption {
        Task task = taskRepo.getDistinctById(id);
        if(Objects.isNull(task)){
            throw new TaskIsNullExeption("Task has not found", "Try to input existing task");
        }
        task.setTaskStatus(taskStatus);
        taskRepo.save(task);
        return ResponseEntity.ok("Success, you have updated your task status");
    }

    @Override
    public ResponseEntity<?> deleteTask(Long id) throws TaskIsNullExeption {
        Task task = taskRepo.getDistinctById(id);
        if(Objects.isNull(task)){
            throw new TaskIsNullExeption("Task not found", "You have entered not existed task");
        }
        if(task.getTaskStatus().equals(TaskStatus.IN_PROGRESS)){
            throw new TaskIsNullExeption("Task in progress", "Task in progress, you can not delete it now");
        }
        taskRepo.delete(task);
        return ResponseEntity.ok("You have deleted " + task.getTaskName() + " task");
    }

    @Override
    public ResponseEntity<?> updateTask(TaskDTO taskDTO) throws TaskIsNullExeption {
        Task task = TaskMapper.INSTANCE.toTask(taskDTO);
        task = taskRepo.getDistinctById(task.getId());
        if(Objects.isNull(task)){
            throw new TaskIsNullExeption("ERROR","the fields are empty");
        }
        if(taskDTO.getEndDate().isBefore(taskDTO.getStartDate())){
            throw new TaskIsNullExeption("ERROR", "the end date can not be earlier than start date");
        }
        if(taskDTO.getPriority()>10 || taskDTO.getPriority()<=0){
            throw new TaskIsNullExeption("ERROR", "The min range of priority is 1 and the max range is 10");
        }
        taskRepo.save(task);

        return ResponseEntity.ok("The task has updated");
    }

    @Override
    public List<TaskDTO> getAll() {
        List<Task> tasks = taskRepo.findAll();
        List<TaskDTO> taskDTOS = new ArrayList<>();
        for(Task t : tasks ){
            taskDTOS.add(TaskMapper.INSTANCE.toTaskDTO(t));
        }
        return taskDTOS;
    }

    @Override
    public List<TaskDTO> getAllByProject(Long id) {
        List<Task> tasks =taskRepo.getAllByProjectId(id);
        List<TaskDTO> taskDTOS = new ArrayList<>();
        for(Task t : tasks){
            taskDTOS.add(TaskMapper.INSTANCE.toTaskDTO(t));
        }
        return taskDTOS;
    }





}
