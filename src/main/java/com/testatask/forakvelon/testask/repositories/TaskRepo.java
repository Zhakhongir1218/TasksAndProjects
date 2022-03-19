package com.testatask.forakvelon.testask.repositories;

import com.testatask.forakvelon.testask.models.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {
    Task getDistinctById(Long id);

    @Query(value = "select * from tasks where project_id = ?1 order by priority desc ", nativeQuery = true)
    List<Task> getAllByProjectId(Long id);
}
