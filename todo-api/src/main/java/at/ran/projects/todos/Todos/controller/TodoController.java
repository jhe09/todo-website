package at.ran.projects.todos.Todos.controller;

import at.ran.projects.todos.Todos.model.Todo;
import at.ran.projects.todos.Todos.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Test

@CrossOrigin
@RestController
public class TodoController {
    @Autowired
    private TodoRepository repo;

    @GetMapping("/todos")
    List<Todo> getAllTodos() {
        List<Todo> todos = repo.findAll();
        return todos;
    }

    @GetMapping("/todos/{id}")
    List<Todo> getTodoForId() {
        List<Todo> todos = new ArrayList<>();
        return todos;
    }

    @PostMapping(value = "/todos", consumes = "application/json")
    public ResponseEntity insertTodo(@RequestBody Todo todo) {
        repo.save(todo);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = "/todos/{id}",consumes = "application/json")
    public ResponseEntity updateTodo(@PathVariable("id") int id,@RequestBody Todo todo){
        todo.setId(id);
        repo.save(todo);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/todos/{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") int id){
        repo.deleteById(id);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
