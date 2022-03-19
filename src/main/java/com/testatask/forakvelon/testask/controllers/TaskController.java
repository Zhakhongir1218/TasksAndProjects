package com.testatask.forakvelon.testask.controllers;

import com.testatask.forakvelon.testask.exceptions.ProjectIsNullException;
import com.testatask.forakvelon.testask.exceptions.TaskIsNullExeption;
import com.testatask.forakvelon.testask.models.dtos.ForSearchingTaskDTO;
import com.testatask.forakvelon.testask.models.dtos.TaskDTO;
import com.testatask.forakvelon.testask.models.enums.TaskStatus;
import com.testatask.forakvelon.testask.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewTask(@RequestBody TaskDTO taskDTO ) throws TaskIsNullExeption, ProjectIsNullException {
        return taskService.createNewTask(taskDTO);
    }

    @PostMapping("/status")
    public ResponseEntity<?> updateTaskStatus(@RequestParam Long id, @RequestParam TaskStatus taskStatus) throws TaskIsNullExeption {
        return taskService.updateTaskStatus(id,taskStatus);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTask(@RequestParam Long id) throws TaskIsNullExeption {
        return taskService.deleteTask(id);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateTask(@RequestBody TaskDTO taskDTO) throws TaskIsNullExeption {
        return taskService.updateTask(taskDTO);
    }
    @GetMapping("/getAll")
    public List<TaskDTO> getAllTasks(){
        return taskService.getAll();
    }

    @GetMapping("/getAll/by/project")
    public List<TaskDTO> getAllByProject(@RequestParam Long id){
        return taskService.getAllByProject(id);
    }

}
