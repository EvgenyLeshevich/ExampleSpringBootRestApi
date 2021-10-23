package com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.entity;

import javax.persistence.*;
import java.util.List;

// Это сущности которые связаны с базами данных
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    // Один пользователь имеет много задач
    // cascade = CascadeType.ALL - если мы удаляем или обновляем пользователя то удаляться и удаляться будут все связанные с ним задачи
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TodoEntity> todoEntities;

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TodoEntity> getTodoEntities() {
        return todoEntities;
    }

    public void setTodoEntities(List<TodoEntity> todoEntities) {
        this.todoEntities = todoEntities;
    }
}
