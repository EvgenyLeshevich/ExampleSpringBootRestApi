package com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.controller;

import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.entity.UserEntity;
import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.expection.UserAlreadyExistException;
import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.expection.UserNotFoundException;
import com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@ComponentScan("com.evgeniy.spring.boot.example.ExampleSpringBootRestApiWithUlbiTV")
public class UserController {

    @Autowired // Пишем для того что бы спринг внедрил объект этого класса
    private UserService userService;

    // В этом методе будем передавать данные с клиента в теле запроса
    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь был успешно сохранён");// Сообщение для клиента
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    // Получение одного пользователя
    // В этом методе мы примем query-параметры - параметры поисковой строки который указываются после вопросительного знака
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id){
        try {
            return ResponseEntity.ok(userService.getOne(id));// Сообщение для клиента
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    //Здесь будем принимать часть строки запроса, через PathVariable - переменная пути
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.deleteUser(id));// Сообщение для клиента
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

//    // Функция с помощью которой мы убеждаемся что наш сервер работает
//    @GetMapping
//    public ResponseEntity getUsers(){
//        try { // Если вс хорошо, то вернётся 200ый статус ОК и вернём нашу логику
//            return ResponseEntity.ok("Сервер работает");
//        } catch (Exception e){ // Здесь отлавливаем ошибки, и если мы попали в этот блок то возвращаем
//            // badRequest()(то есть на клиента вернётся 400ый статус ошибки и в тело поместим нашу логику
//            return ResponseEntity.badRequest().body("Произошла ошибка");
//        }
//    }
}
