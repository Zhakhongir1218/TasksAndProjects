package com.testatask.forakvelon.testask.models.entities;


import com.testatask.forakvelon.testask.models.enums.TaskStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "task_name", length = 30)
    String taskName;

    @Column(name = "task_description", length = 500)
    String taskDescription;

    @Column(name = "start_date")
    LocalDateTime startDate;

    @Column(name = "end_date")
    LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    TaskStatus taskStatus;

    Integer priority;

    @ManyToOne
    @JoinColumn(name = "project_id")
    Project project;


}
