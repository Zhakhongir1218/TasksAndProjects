package com.testatask.forakvelon.testask.mappers;

import com.testatask.forakvelon.testask.models.dtos.TaskDTO;
import com.testatask.forakvelon.testask.models.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    Task toTask(TaskDTO taskDTO);

    TaskDTO toTaskDTO(Task task);
}
