package tech.silva.kanban.web.controller;

import ch.qos.logback.core.model.processor.PhaseIndicator;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.silva.kanban.entity.Task;
import tech.silva.kanban.service.TaskService;
import tech.silva.kanban.web.dto.TaskCreateDto;
import tech.silva.kanban.web.dto.TaskResponseDto;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> saveTask(@RequestBody TaskCreateDto taskCreateDto){
        Task task = taskService.saveTask(taskCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(TaskResponseDto.toResponse(task));
    }
}


