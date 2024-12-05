package kr.ac.mjc.todo_List.controller;


import kr.ac.mjc.todo_List.domain.Todo_list;
import kr.ac.mjc.todo_List.dto.TodoRequest;
import kr.ac.mjc.todo_List.dto.TodoResponse;
import kr.ac.mjc.todo_List.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TodoViewController {

    @Autowired
    TodoService todoService;


    @GetMapping("/")
    public ModelAndView main() {
        ModelAndView mav = new ModelAndView();
        List<Todo_list> todoLists = todoService.getTodoList();
        mav.addObject("todoLists", todoLists);
        mav.setViewName("main");
        return mav;

    }

    @GetMapping("/write/Todolist")
    public String write() {
        return "write";
    }

    @GetMapping("/Todolist/{id}")
    public ModelAndView view(@PathVariable(name = "id") Long id) {
        Todo_list todoList = todoService.getItem(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("todoList",todoList);
        mav.setViewName("view");

        return mav;
    }

    @GetMapping("/Todolist/modify/{id}")
    public ModelAndView modify(@PathVariable(name="id")Long id) {
        ModelAndView mav = new ModelAndView();
        Todo_list todoList = todoService.getItem(id);

        mav.addObject("todoList",todoList);
        mav.setViewName("modify");
        return mav;
    }





















//    @PostMapping("/Todolist/write")
//    public ModelAndView TodoListWrite(@ModelAttribute TodoRequest todoRequest) {
//        TodoResponse response = todoService.writeTodoList(todoRequest);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("todoList",response.getTodo_list());
//        mav.setViewName("redirect:/");
//
//        return mav;
//    }
}
