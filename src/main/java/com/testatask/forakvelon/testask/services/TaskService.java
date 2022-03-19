package com.testatask.forakvelon.testask.services;

import com.testatask.forakvelon.testask.exceptions.ProjectIsNullException;
import com.testatask.forakvelon.testask.exceptions.TaskIsNullExeption;
import com.testatask.forakvelon.testask.models.dtos.ForSearchingTaskDTO;
import com.testatask.forakvelon.testask.models.dtos.TaskDTO;
import com.testatask.forakvelon.testask.models.enums.TaskStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    ResponseEntity<?> createNewTask(TaskDTO taskDTO) throws TaskIsNullExeption, ProjectIsNullException;

    ResponseEntity<?> updateTaskStatus(Long id, TaskStatus taskStatus) throws TaskIsNullExeption;

    ResponseEntity<?> deleteTask(Long id) throws TaskIsNullExeption;

    ResponseEntity<?> updateTask(TaskDTO taskDTO) throws TaskIsNullExeption;

    List<TaskDTO> getAll();

    List<TaskDTO> getAllByProject(Long id);
}
