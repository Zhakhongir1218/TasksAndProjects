package com.testatask.forakvelon.testask.models.dtos;

import com.testatask.forakvelon.testask.models.enums.ProjectStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectDTO {


    Long id;

    String name;

    ProjectStatus projectStatus;

    LocalDateTime start_date;

    LocalDateTime end_date;

    Integer priority;

}
