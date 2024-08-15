package com.sparta.todolist.service;

import com.sparta.todolist.dto.ToDoListRequestDto;
import com.sparta.todolist.dto.ToDoListResponseDto;
import com.sparta.todolist.entity.ToDoList;
import com.sparta.todolist.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
    public List<ToDoListResponseDto> getAllByValue(int value, String managerName, Timestamp modifiedDate) {
        //value ==0 매니저이름으로 조회 1 = 수정일로 조회 2 = 두조건으로 조회
        if(value==0) {
            return toDoListRepository.findByManagerName(managerName);
        } else if (value == 1) {
            return toDoListRepository.findByModifiedDate(modifiedDate);
        } else if (value == 2) {
            return toDoListRepository.findByModifiedDateAndManagerName(modifiedDate, managerName);
        } else {
            throw new IllegalArgumentException("Invalid value");
        }
    }

    public ToDoListResponseDto updateToDoList(int id,ToDoListRequestDto requestDto) {
        ToDoList toDoList = toDoListRepository.findById(id);
        if(toDoList != null) {
            toDoList=toDoListRepository.passwordVerify(requestDto);
            if(toDoList != null) {

                ToDoList todoList = toDoListRepository.update(requestDto);
                ToDoListResponseDto responseDto = new ToDoListResponseDto(todoList);
                return responseDto;
            }
            else {
                throw new IllegalArgumentException("비밀 번호가 틀렸습니다.");
            }
        } else {
            throw new IllegalArgumentException("선택한 일정은 존재하지 않습니다.");
        }
    }
    public int deleteToDoList(int id,ToDoListRequestDto requestDto) {

        ToDoList toDoList = toDoListRepository.findById(id);
        if(toDoList != null) {
            toDoList=toDoListRepository.passwordVerify(requestDto);
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
    public ToDoListResponseDto getToDoList(int id,ToDoListRequestDto requestDto) {
        ToDoList toDoList = toDoListRepository.findById(id);
        if(toDoList !=null) {
            ToDoListResponseDto responseDto = new ToDoListResponseDto(toDoList);
            return responseDto;
        }
        else {
            throw new IllegalArgumentException("해당 id의 메모는 존재하지않습니다.");
        }
    }
}
