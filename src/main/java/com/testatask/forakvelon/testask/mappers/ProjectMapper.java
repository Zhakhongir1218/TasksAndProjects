package com.testatask.forakvelon.testask.mappers;

import com.testatask.forakvelon.testask.models.dtos.ProjectDTO;
import com.testatask.forakvelon.testask.models.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    Project toProject(ProjectDTO projectDTO);

    ProjectDTO toProjectDTO(Project project);
}
