package com.prashant.todo.contollers;

import com.prashant.todo.models.ToDo;
import com.prashant.todo.services.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    Logger logger = LoggerFactory.getLogger(ToDoController.class);

    @Autowired
    private ToDoService toDoService;

    Random random = new Random();

    @PostMapping
    public ResponseEntity<ToDo> createToDoHandler(@RequestBody ToDo toDo)
    {
        logger.info("create todo");
        int id = random.nextInt(9999);
        toDo.setId(id);

        ToDo toDo1 = toDoService.createTodo(toDo);
        return new ResponseEntity<>(toDo1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllToDoHandler(){
        List<ToDo> allToDos= toDoService.getAllToDos();
        return new ResponseEntity<>(allToDos,HttpStatus.OK);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<ToDo> getSingleToDoHandler(@PathVariable int todoId){

        ToDo todo = toDoService.getToDo(todoId);
        return ResponseEntity.ok(todo);
    }
}
