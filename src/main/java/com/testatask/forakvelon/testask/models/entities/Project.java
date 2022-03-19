package com.testatask.forakvelon.testask.models.entities;

import com.testatask.forakvelon.testask.models.enums.ProjectStatus;
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
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "project_status")
    ProjectStatus projectStatus;

    LocalDateTime start_date;

    LocalDateTime end_date;

    Integer priority;

}
