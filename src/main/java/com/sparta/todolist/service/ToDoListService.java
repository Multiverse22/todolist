package com.sparta.todolist.service;

import com.sparta.todolist.dto.ToDoListRequestDto;
import com.sparta.todolist.dto.ToDoListResponseDto;
import com.sparta.todolist.entity.ToDoList;
import com.sparta.todolist.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService( ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public ToDoListResponseDto createToDoList(ToDoListRequestDto requestDto) {
        //requestDto -> Entity
        ToDoList toDoList = new ToDoList(requestDto);

        ToDoList savedToDoList = toDoListRepository.save(toDoList);

        ToDoListResponseDto responseDto = new ToDoListResponseDto(savedToDoList);

        return responseDto;
    }

    public List<ToDoListResponseDto> getAllToDoList() {
        //모든할일 가져오기
        return toDoListRepository.findAll();
    }

    public ToDoListResponseDto updateToDoList(int id,String password, ToDoListRequestDto requestDto) {
        ToDoList toDoList = toDoListRepository.findById(id);
        if(toDoList != null) {
            toDoList=toDoListRepository.passwordVerify(id,password);
            if(toDoList != null) {

                ToDoList todoList = toDoListRepository.update(id, password, requestDto);
                ToDoListResponseDto responseDto = new ToDoListResponseDto(toDoList);
                return responseDto;
            }
            else {
                throw new IllegalArgumentException("비밀 번호가 틀렸습니다.");
            }
        } else {
            throw new IllegalArgumentException("선택한 일정은 존재하지 않습니다.");
        }
    }
    public int deleteToDoList(int id,String password) {

        ToDoList toDoList = toDoListRepository.findById(id);
        if(toDoList != null) {
            toDoList=toDoListRepository.passwordVerify(id,password);
            if(toDoList !=null) {

                toDoListRepository.delete(id);
                return id;
            }
            else {
                throw new IllegalArgumentException("비밀 번호가 틀렸습니다.");
            }
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }
    public ToDoListResponseDto getToDoList(int id) {
        ToDoList toDoList = toDoListRepository.findById(id);
        ToDoListResponseDto responseDto = new ToDoListResponseDto(toDoList);
        return responseDto;
    }
}
