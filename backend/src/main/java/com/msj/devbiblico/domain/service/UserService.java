package com.msj.devbiblico.domain.service;

import com.msj.devbiblico.domain.model.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findById(Long id);

    public User save(User user);

    public User update(User user);

    public void delete(Long id);

    public List<User> findUserByName(String username);

    public User findUserByEmail(String email);

}
