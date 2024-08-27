package tech.silva.kanban.service;

import org.springframework.stereotype.Service;
import tech.silva.kanban.entity.Task;
import tech.silva.kanban.exception.ObjectNotFoundException;
import tech.silva.kanban.repository.ITaskRepository;
import tech.silva.kanban.web.dto.TaskCreateDto;

import java.util.List;

@Service
public class TaskService {

    private final ITaskRepository iTaskRepository;

    public TaskService(ITaskRepository iTaskRepository) {
        this.iTaskRepository = iTaskRepository;
    }

    public Task saveTask(TaskCreateDto taskCreateDto) {
        Task task = new Task();
        task.setTitle(taskCreateDto.title());
        return iTaskRepository.save(task);
    }

    public List<Task> findAllByStatus(String status) {
        return switch (status){
            case "BACKLOG" ->  iTaskRepository.findAllByStatus(Task.Status.BACKLOG);
            case "SPRINT" ->  iTaskRepository.findAllByStatus(Task.Status.SPRINT);
            case "PROGRESS" ->  iTaskRepository.findAllByStatus(Task.Status.PROGRESS);
            case "DONE" ->  iTaskRepository.findAllByStatus(Task.Status.DONE);
            default -> throw new ObjectNotFoundException(String.format("Task status: %s not found", status));
        };
    }

    public void updateStatus(String status, Long id) {
        Task task = iTaskRepository.findById(id)
                .orElseThrow(
                        () -> new ObjectNotFoundException(String.format("Task id: %s not found", id))
                );
        switch (status){
            case "BACKLOG" -> task.setStatus(Task.Status.BACKLOG);
            case "SPRINT" -> task.setStatus(Task.Status.SPRINT);
            case "PROGRESS" -> task.setStatus(Task.Status.PROGRESS);
            case "DONE" -> task.setStatus(Task.Status.DONE);
        }
        iTaskRepository.save(task);
    }
}
