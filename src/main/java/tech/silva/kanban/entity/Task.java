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
    private Status status = Status.BACKLOG;

    public enum Status{
        BACKLOG, SPRINT, PROGRESS, DONE
    }

    public Task(Long id, String title, Status status) {
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public Task(String title, Status status) {
        this.title = title;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
