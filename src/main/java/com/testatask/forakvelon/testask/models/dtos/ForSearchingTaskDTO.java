package com.testatask.forakvelon.testask.models.dtos;

import com.testatask.forakvelon.testask.models.enums.TaskStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ForSearchingTaskDTO {
    Long id;

    String taskName;

    String taskDescription;

    LocalDateTime startDate;

    LocalDateTime endDate;

    TaskStatus taskStatus;

    Integer priority;

    Long projectId;
}
