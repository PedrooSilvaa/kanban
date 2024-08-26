package tech.silva.kanban.web.dto;

import tech.silva.kanban.entity.Task;

import java.util.List;
import java.util.stream.Collectors;

public record TaskResponseDto (Long id,
                               String title,
                               String status){

    public TaskResponseDto(Long id, String title, String status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public static TaskResponseDto toResponse(Task task){
        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getStatus().name()
        );
    }

    public static List<TaskResponseDto> toListResponse(List<Task> tasks){
        return tasks.stream()
                .map(task -> toResponse(task)).collect(Collectors.toList());
    }
}
