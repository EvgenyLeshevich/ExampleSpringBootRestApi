package com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.service;

import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.entity.UserEntity;
import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.expection.UserAlreadyExistException;
import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.expection.UserNotFoundException;
import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.model.User;
import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Сервис работает с какой-то конкретной логикой
@Service
public class UserService {

    @Autowired // Пишем для того что бы спринг внедрил объект этого класса
    private UserRepo userRepo;

    // Метод содержит ошибку в сигнатуре, её нужно обработать в блоке try catch в другом месте
    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername())!=null){
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }

    public Long deleteUser(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
