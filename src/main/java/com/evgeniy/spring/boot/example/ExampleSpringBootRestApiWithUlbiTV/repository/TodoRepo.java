package com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.repository;

import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
