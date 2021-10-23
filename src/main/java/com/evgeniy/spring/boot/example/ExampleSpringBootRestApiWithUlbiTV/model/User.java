package com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.model;

import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

// С помощью моделей происходит обмен данными между клиентом и сервером,
// здесь мы указываем только те поля который будут использоваться на клиенте
public class User {
    private Long id;
    private String username;
    private List<Todo> todoList;

    // Функция конвертер - мы принимаем на вход entity, а возвращаем model
    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        // Используем stream - вызываем на нём функцию map(она выполняет функцию(toModel) переданную параметром
        // для каждого элемента массива, с помощью функции collect - преобразовываем результат в List
        model.setTodoList(entity.getTodoEntities().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }

    public User() {
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

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }
}
