package kr.ac.mjc.todo_List.dto;

import kr.ac.mjc.todo_List.domain.Todo_list;

public class TodoResponse {

    private boolean success;
    private Todo_list todo_list;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Todo_list getTodo_list() {
        return todo_list;
    }

    public void setTodo_list(Todo_list todo_list) {
        this.todo_list = todo_list;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
