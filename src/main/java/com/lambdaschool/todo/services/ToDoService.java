package com.lambdaschool.todo.services;

import com.lambdaschool.todo.models.ToDo;

public interface ToDoService {

    ToDo save(ToDo todo);

    ToDo update(ToDo todo, long id);
}
