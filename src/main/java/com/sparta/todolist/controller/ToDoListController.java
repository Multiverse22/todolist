package com.sparta.todolist.controller;


import com.sparta.todolist.dto.ToDoListRequestDto;
import com.sparta.todolist.dto.ToDoListResponseDto;
import com.sparta.todolist.service.ToDoListService;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoListController {

    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping("/todolist")
    public ToDoListResponseDto createToDoList(@RequestBody ToDoListRequestDto requestDto) {
        //TodoList작성하는 메서드 객체로 받았기 때문에 @RequestBody 애너테이션 필요 리턴은 ResponseDto로 리턴
        return toDoListService.createToDoList(requestDto);

    }
    @GetMapping("/todolist/{id}")
    public ToDoListResponseDto getToDoList(ToDoListRequestDto requestDto) {
        //@PathVariable 애너테이션을 사용하면 /todolist/(id값) 이런식으로 url을 작성해야한다.
        return toDoListService.getToDoList(requestDto);
    }

    @GetMapping("/todolist")
    public List<ToDoListResponseDto> getAllToDoLists() {
        return toDoListService.getAllToDoList();
    }


    @PutMapping("/todolist")
    public ToDoListResponseDto updateToDoList( @RequestBody ToDoListRequestDto requestDto) {
        return toDoListService.updateToDoList(requestDto);
    }

    @DeleteMapping("/todolist/{id}")
    public int deleteToDoList(@PathVariable int id,@RequestBody ToDoListRequestDto requestDto) {
        return toDoListService.deleteToDoList(id,requestDto);
    }
    @GetMapping ("/todolist/inquiry/{value}")
    public List<ToDoListResponseDto> getToDoListsByValue(@PathVariable int value, @RequestParam(required = false) String managerName, @RequestParam(required = false) Timestamp modifiedDate) {
        return toDoListService.getAllByValue(value,managerName,modifiedDate);
    }
}
