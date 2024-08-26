package tech.silva.kanban.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String  title;

    public tasks(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public tasks() {
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
