package com.testatask.forakvelon.testask.repositories;

import com.testatask.forakvelon.testask.models.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {

    Project findDistinctById(Long id);
}
