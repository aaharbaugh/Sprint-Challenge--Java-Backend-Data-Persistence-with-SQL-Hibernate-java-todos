package com.lambdaschool.todo.services;

import com.lambdaschool.todo.models.ToDo;
import com.lambdaschool.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service(value = "todoService")
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    ToDoRepository todorepos;

    @Transactional
    @Override
    public ToDo save(ToDo todo) {
        return todorepos.save(todo);
    }

    @Transactional
    @Override
    public ToDo update(ToDo todo, long id)
    {
        ToDo currentTodo = todorepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (todo.getDescription() != null)
        {
            currentTodo.setDescription(todo.getDescription());
        }

        if (todo.isCompleted() == true)
        {
            currentTodo.setCompleted(true);
        }
        if (todo.isCompleted() == false)
        {
            currentTodo.setCompleted(false);
        }

        return todorepos.save(currentTodo);
    }
}
