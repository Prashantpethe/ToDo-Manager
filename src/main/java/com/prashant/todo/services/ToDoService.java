package com.prashant.todo.services;

import com.prashant.todo.models.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ToDoService {

    Logger logger = LoggerFactory.getLogger(ToDoService.class);

    List <ToDo> todos = new ArrayList<>();

    public ToDo createTodo(ToDo toDo)
    {
            todos.add(toDo);
            logger.info("ToDo{}",this.todos);
            return toDo;
    }

    public List<ToDo> getAllToDos() {

        return todos;
    }

    public ToDo getToDo(int toDoId) {

       ToDo toDo= todos.stream().filter(t->toDoId == t.getId()).findAny().get();
       logger.info("ToDo:{}",toDo);
       return toDo;
    }
}
