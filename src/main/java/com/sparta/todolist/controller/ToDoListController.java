package com.sparta.todolist.controller;


import com.sparta.todolist.dto.ToDoListRequestDto;
import com.sparta.todolist.dto.ToDoListResponseDto;
import com.sparta.todolist.service.ToDoListService;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoListController {

    private final JdbcTemplate jdbcTemplate;

    public ToDoListController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/todolist")
    public ToDoListResponseDto createToDoList(@RequestBody ToDoListRequestDto requestDto) {
        //TodoList작성하는 메서드 객체로 받았기 때문에 @RequestBody 애너테이션 필요 리턴은 ResponseDto로 리턴
        ToDoListService toDoListService = new ToDoListService(jdbcTemplate);
        return toDoListService.createToDoList(requestDto);

    }

    @GetMapping("/todolist")
    public List<ToDoListResponseDto> getAllToDoLists() {
        ToDoListService toDoListService = new ToDoListService(jdbcTemplate);
        return toDoListService.getAllToDoList();
    }


    @PutMapping("/todolist/{id}")
    public int updateToDoList(@PathVariable int id, @RequestBody ToDoListRequestDto requestDto) {
        ToDoListService toDoListService = new ToDoListService(jdbcTemplate);
        return toDoListService.updateToDoList(id, requestDto);
    }

    @DeleteMapping("/todolist/{id}")
    public int deleteToDoList(@PathVariable int id) {
        ToDoListService toDoListService = new ToDoListService(jdbcTemplate);
        return toDoListService.deleteToDoList(id);
    }
}
