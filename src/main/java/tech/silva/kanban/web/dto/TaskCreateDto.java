package tech.silva.kanban.web.dto;

import jakarta.validation.constraints.NotBlank;

public record TaskCreateDto (@NotBlank
                             String title,
                             @NotBlank
                             String status){
}
