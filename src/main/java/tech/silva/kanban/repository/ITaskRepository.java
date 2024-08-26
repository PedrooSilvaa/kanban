package tech.silva.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.silva.kanban.entity.Task;

import java.util.List;

public interface ITaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(Task.Status status);
}
