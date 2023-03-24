package com.prashant.todo.services;

import com.prashant.todo.models.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Component
@Service
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



    public ToDo updateToDo(ToDo newToDo, int todoId) {

        todos= todos.stream().map(t->{
              if(t.getId()==todoId)
              {
                  t.setTitle(newToDo.getTitle());
                  t.setContent(newToDo.getContent());
                  t.setStatus(newToDo.getStatus());
                  return t;
              }else{
                  return t;
              }
          }).collect(Collectors.toList());
      newToDo.setId(todoId);
      return newToDo;
    }

    public void deleteToDo(int todoId) {
        logger.info("Todo is being deleted");
        todos = todos.stream().filter(t->t.getId()!=todoId).collect(Collectors.toList());
    }
}
