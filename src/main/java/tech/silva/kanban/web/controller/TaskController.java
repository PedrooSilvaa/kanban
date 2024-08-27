package tech.silva.kanban.web.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.silva.kanban.entity.Task;
import tech.silva.kanban.service.TaskService;
import tech.silva.kanban.web.dto.TaskCreateDto;
import tech.silva.kanban.web.dto.TaskResponseDto;

import java.util.List;

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

    @GetMapping("/{status}")
    public ResponseEntity<List<TaskResponseDto>> listByStatus(@PathVariable String status){
        List<Task> tasks = taskService.findAllByStatus(status);
        return ResponseEntity.ok().body(TaskResponseDto.toListResponse(tasks));
    }

    @PutMapping("/{status}/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable String status, @PathVariable Long id){
        taskService.updateStatus(status, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}


