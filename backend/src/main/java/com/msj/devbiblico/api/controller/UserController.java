package com.msj.devbiblico.api.controller;

import com.msj.devbiblico.domain.exception.EmailCreatedException;
import com.msj.devbiblico.domain.exception.EntidadeNaoEncontradaException;
import com.msj.devbiblico.domain.exception.UserCreatedException;
import com.msj.devbiblico.domain.model.User;
import com.msj.devbiblico.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("http://localhost:4200/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> allUsers() {
        return userService.all();
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user) {
        try {
            user = userService.create(user);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(user);
        } catch (UserCreatedException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }catch (EmailCreatedException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }


}
