package tech.silva.kanban.web.dto;

import jakarta.validation.constraints.NotBlank;
import tech.silva.kanban.entity.Task;

public record TaskCreateDto (@NotBlank
                             String title,
                             @NotBlank
                             String status){

}
