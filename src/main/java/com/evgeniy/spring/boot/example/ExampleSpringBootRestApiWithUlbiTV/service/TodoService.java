package com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.service;

import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.entity.TodoEntity;
import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.entity.UserEntity;
import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.model.Todo;
import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.repository.TodoRepo;
import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired // Пишем для того что бы спринг внедрил объект этого класса
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo complete(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
