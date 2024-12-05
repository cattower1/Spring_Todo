package kr.ac.mjc.todo_List.service;


import jakarta.transaction.Transactional;
import kr.ac.mjc.todo_List.domain.Todo_list;
import kr.ac.mjc.todo_List.dto.TodoRequest;
import kr.ac.mjc.todo_List.dto.TodoResponse;
import kr.ac.mjc.todo_List.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    //홈 가져올떄씀
    @Autowired
    TodoRepository todoRepository;

    public List<Todo_list> getTodoList() {
        return todoRepository.findAll();
    }


    //할일 작성하는 기능을 한다.
    public TodoResponse writeTodoList(TodoRequest todoRequest) {
        TodoResponse response = new TodoResponse();
        Todo_list todo = new Todo_list();
        todo.setTitle(todoRequest.getTitle());
        todo.setContent(todoRequest.getContent());

        if (!todo.getTitle().matches(".*\\d.*")) { //숫자를 포함하는가
            response.setSuccess(false);
            response.setMessage("제목에는 숫자를 포함한 날짜가 들어가야 합니다.");
            return response;
        }

        todo = todoRepository.save(todo);
        response.setSuccess(true);
        response.setTodo_list(todo);
        return response;
    }

    //한개 목록 가져오기
    public Todo_list getItem(long id) {
        Optional<Todo_list> result = todoRepository.findById(id);
        if (result.isEmpty()) {
            return null;
        } return result.get();
    }

    //삭제
    public TodoResponse deleteTodolist(long id) {
        Optional<Todo_list> result = todoRepository.findById(id);
        TodoResponse response = new TodoResponse();

        if (result.isEmpty()){ // 할일 없는경우
            response.setSuccess(false);
            response.setMessage("글 작성 안함(존재하지 않음)");
        }else {
            todoRepository.deleteById(id);
            response.setSuccess(true);
        }
       return response;
    }

    //글 수정하는
    @Transactional
    public TodoResponse modifyTodolist(long id,TodoRequest todoRequest) {
        Optional<Todo_list> optTodoList = todoRepository.findById(id);

        TodoResponse response= new TodoResponse();
        if (optTodoList.isEmpty()) {
            response.setSuccess(false);
            response.setMessage("존재하는 않는 글입니다");
        } else {
            Todo_list todoList=optTodoList.get();
            todoList.setTitle(todoRequest.getTitle());
            todoList.setContent(todoRequest.getContent());
            todoRepository.save(todoList);
            response.setSuccess(true);
            response.setTodo_list(todoList);
        }
        return response;
    }




}
