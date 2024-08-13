package com.sparta.todolist.entity;

import java.time.LocalDate;
import com.sparta.todolist.dto.ToDoListRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ToDoList {
    private int id;
    private String managerName;
    private String toDoListContents;
    private LocalDate creationDate;
    private LocalDate modifyDate;
    private String password;

    public ToDoList(ToDoListRequestDto toDoListRequestDto) {
        this.managerName=toDoListRequestDto.getManagerName();
        this.toDoListContents=toDoListRequestDto.getToDoListContents();
        this.password=toDoListRequestDto.getPassword();
        this.creationDate=toDoListRequestDto.getCreationDate();
        this.modifyDate=toDoListRequestDto.getModifyDate();
    }

    public void update(ToDoListRequestDto requestDto) {
        this.managerName=requestDto.getManagerName();
        this.toDoListContents=requestDto.getToDoListContents();
        this.modifyDate=requestDto.getModifyDate();

    }
}
