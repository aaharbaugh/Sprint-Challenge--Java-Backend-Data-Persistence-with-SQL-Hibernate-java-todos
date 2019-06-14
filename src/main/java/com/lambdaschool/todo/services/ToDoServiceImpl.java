package com.lambdaschool.todo.services;

import com.lambdaschool.todo.models.ToDo;
import com.lambdaschool.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "todoService")
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    ToDoRepository todorepos;

    @Transactional
    @Override
    public ToDo save(ToDo todo) {
        return todorepos.save(todo);
    }
}
