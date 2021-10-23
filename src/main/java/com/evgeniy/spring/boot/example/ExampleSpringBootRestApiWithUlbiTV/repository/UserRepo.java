package com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.repository;

import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

//Репозиторий работает с базой данных
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
