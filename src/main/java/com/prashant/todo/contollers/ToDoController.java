package com.prashant.todo.contollers;

import com.prashant.todo.models.ToDo;
import com.prashant.todo.services.ToDoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
      //  String str= null;
      //  logger.info("{}",str.length());

     //   Integer.parseInt("ab123cds");
        logger.info("create todo");
        int id = random.nextInt(9999);
        toDo.setId(id);
        Date currentDate = new Date();
        logger.info("Current data is :{}",currentDate);
        logger.info("ToDo Date :{}",toDo.getToDoDate());
        toDo.setAddedDate(currentDate);
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

    @PutMapping("/{todoId}")
    public ResponseEntity<ToDo> updateToDoHandler(@RequestBody ToDo newToDo,@PathVariable int todoId){
        ToDo todo=toDoService.updateToDo(newToDo,todoId);
        return new ResponseEntity<>(todo,HttpStatus.OK);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity deleteToDoHandler(@PathVariable int todoId)
    {
        toDoService.deleteToDo(todoId);
        return ResponseEntity.ok("ToDo deleted successfully");
    }

   /* @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> nullPointerExceptionHandler(NullPointerException ex)
    {
        System.out.println(ex.getMessage());
        System.out.println("Null pointer exception generated");
        return new ResponseEntity<>("Null pointer exception generated" +ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }*/

 /*   @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> numberFormatExceptionHandler(NumberFormatException nex)
    {
        System.out.println(nex.getMessage());
        System.out.println("Null pointer exception generated");
        return new ResponseEntity<>("Null pointer exception generated" +nex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }*/

  /*  @ExceptionHandler(value={NumberFormatException.class,NullPointerException.class})
    public ResponseEntity<String> numberFormatExceptionHandler(Exception e)
    {
        System.out.println(e.getMessage());
        System.out.println("Null pointer exception generated");
        return new ResponseEntity<>("Null pointer exception generated" +e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }*/



}
