package kr.ac.mjc.todo_List.controller;


import kr.ac.mjc.todo_List.domain.Todo_list;
import kr.ac.mjc.todo_List.dto.TodoRequest;
import kr.ac.mjc.todo_List.dto.TodoResponse;
import kr.ac.mjc.todo_List.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoApiController {

    @Autowired
    TodoService todoService;

    @PostMapping("/api/Todolist")
    public ResponseEntity<TodoResponse> writeTodolist(@RequestBody TodoRequest todoRequest) {
        TodoResponse response = todoService.writeTodoList(todoRequest);

        return ResponseEntity.ok(response);

    }


    @DeleteMapping("/api/Todolist/{id}")
    public ResponseEntity<TodoResponse> deleteTodolist(@PathVariable("id") long id) {
        TodoResponse response = todoService.deleteTodolist(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/api/Todolist/{id}")
    public ResponseEntity<TodoResponse> modifyTodo(@PathVariable("id") long id, @RequestBody TodoRequest todoRequest) {
        TodoResponse response = todoService.modifyTodolist(id, todoRequest);
        return ResponseEntity.ok(response);
    }
}
