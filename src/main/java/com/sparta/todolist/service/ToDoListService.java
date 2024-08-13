package com.sparta.todolist.service;

import com.sparta.todolist.dto.ToDoListRequestDto;
import com.sparta.todolist.dto.ToDoListResponseDto;
import com.sparta.todolist.entity.ToDoList;
import com.sparta.todolist.repository.ToDoListRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ToDoListService {

    private final JdbcTemplate jdbcTemplate;

    public ToDoListService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ToDoListResponseDto createToDoList(ToDoListRequestDto requestDto) {
        //requestDto -> Entity
        ToDoList toDoList = new ToDoList(requestDto);

        ToDoListRepository toDoListRepository = new ToDoListRepository(jdbcTemplate);
        ToDoList savedToDoList = toDoListRepository.save(toDoList);

        ToDoListResponseDto responseDto = new ToDoListResponseDto(savedToDoList);

        return responseDto;
    }

    public List<ToDoListResponseDto> getAllToDoList() {
        //모든할일 가져오기
        ToDoListRepository toDoListRepository = new ToDoListRepository(jdbcTemplate);
        return toDoListRepository.findAll();
    }

    public int updateToDoList(int id, ToDoListRequestDto requestDto) {
        ToDoListRepository toDoListRepository = new ToDoListRepository(jdbcTemplate);
        ToDoList toDoList = toDoListRepository.findById(id);
        if(toDoList != null) {

            toDoListRepository.update(id,requestDto);

            return id;
        } else {
            throw new IllegalArgumentException("선택한 일정한 존재하지 않습니다.");
        }
    }
    public int deleteToDoList(int id) {
        ToDoListRepository toDoListRepository = new ToDoListRepository(jdbcTemplate);

        ToDoList toDoList = toDoListRepository.findById(id);
        if(toDoList != null) {

            toDoListRepository.delete(id);

            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }
}
