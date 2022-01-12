package com.msj.devbiblico.domain.service;

import com.msj.devbiblico.domain.model.User;
import com.msj.devbiblico.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }


}
