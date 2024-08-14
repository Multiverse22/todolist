package com.sparta.todolist.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.todolist.entity.ToDoList;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ToDoListResponseDto {
    private int id;
    private String managerName;
    private String toDoListContents;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss")
    private Timestamp creationDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss")
    private Timestamp modifiedDate;

    public ToDoListResponseDto(ToDoList toDoList) {
        this.id = toDoList.getId();
        this.managerName = toDoList.getManagerName();
        this.toDoListContents = toDoList.getToDoListContents();
        this.creationDate = toDoList.getCreationDate();
        this.modifiedDate = toDoList.getModifiedDate();
    }

    public ToDoListResponseDto(int id,String managerName, String toDoListContents, Timestamp creationDate, Timestamp modifiedDate) {
        this.id=id;
        this.managerName=managerName;
        this.toDoListContents=toDoListContents;
        this.creationDate=creationDate;
        this.modifiedDate=modifiedDate;
    }
}
