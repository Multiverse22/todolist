package com.sparta.todolist.dto;

import com.sparta.todolist.entity.ToDoList;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ToDoListResponseDto {
    private int id;
    private String managerName;
    private String toDoListContents;
    private LocalDate creationDate;
    private LocalDate modifydate;
    private String password;

    public ToDoListResponseDto(ToDoList toDoList) {
        this.id = toDoList.getId();
        this.managerName = toDoList.getManagerName();
        this.toDoListContents = toDoList.getToDoListContents();
        this.creationDate = toDoList.getCreationDate();
        this.modifydate = toDoList.getModifyDate();
        this.password = toDoList.getPassword();
    }

    public ToDoListResponseDto(int id,String managerName, String toDoListContents,LocalDate creationdate, LocalDate modifydate, String password) {
        this.id=id;
        this.managerName=managerName;
        this.toDoListContents=toDoListContents;
        this.creationDate=creationdate;
        this.modifydate=modifydate;
        this.password=password;

    }
}
