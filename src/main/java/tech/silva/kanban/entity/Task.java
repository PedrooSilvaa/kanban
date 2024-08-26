package tech.silva.kanban.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  title;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status{
        BACKLOG, SPRINT, PROGRESS, DONE
    }
    public Task(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
