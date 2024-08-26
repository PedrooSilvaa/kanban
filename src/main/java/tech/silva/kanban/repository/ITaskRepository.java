package tech.silva.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.silva.kanban.entity.Task;

public interface ITaskRepository extends JpaRepository<Task, Long> {
}
