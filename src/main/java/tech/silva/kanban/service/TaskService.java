package tech.silva.kanban.service;

import org.springframework.stereotype.Service;
import tech.silva.kanban.entity.Task;
import tech.silva.kanban.repository.ITaskRepository;
import tech.silva.kanban.web.dto.TaskCreateDto;

@Service
public class TaskService {

    private final ITaskRepository iTaskRepository;

    public TaskService(ITaskRepository iTaskRepository) {
        this.iTaskRepository = iTaskRepository;
    }

    public Task saveTask(TaskCreateDto taskCreateDto) {
        Task task = new Task();
        task.setTitle(taskCreateDto.title());
        switch (taskCreateDto.status()){
            case "BACKLOG" -> task.setStatus(Task.Status.BACKLOG);
            case "SPRINT" -> task.setStatus(Task.Status.SPRINT);
            case "PROGRESS" -> task.setStatus(Task.Status.PROGRESS);
            case "DONE" -> task.setStatus(Task.Status.DONE);
        }
        return iTaskRepository.save(task);
    }
}
