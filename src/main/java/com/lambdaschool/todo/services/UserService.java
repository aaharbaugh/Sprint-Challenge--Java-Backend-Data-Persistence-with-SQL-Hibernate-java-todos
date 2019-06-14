package com.lambdaschool.todo.services;

import com.lambdaschool.todo.models.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findUserById(long id);

    User findUserByUsername(String username);

    void delete(long id);

    User save(User user);

    User update(User user, long id);
}