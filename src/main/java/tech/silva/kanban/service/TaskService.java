package tech.silva.kanban.service;

import org.springframework.stereotype.Service;
import tech.silva.kanban.repository.ITaskRepository;

@Service
public class TaskService {

    private final ITaskRepository iTaskRepository;

    public TaskService(ITaskRepository iTaskRepository) {
        this.iTaskRepository = iTaskRepository;
    }
}
