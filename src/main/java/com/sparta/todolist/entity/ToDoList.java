package com.sparta.todolist.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sparta.todolist.dto.ToDoListRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDoList {
    private int id;
    private String managerName;
    private String toDoListContents;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss")
    private Timestamp creationDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd HH:mm:ss")
    private Timestamp modifiedDate;
    private String password;

    public ToDoList(ToDoListRequestDto toDoListRequestDto) {
        this.managerName=toDoListRequestDto.getManagerName();
        this.toDoListContents=toDoListRequestDto.getToDoListContents();
        this.password=toDoListRequestDto.getPassword();
        this.creationDate=toDoListRequestDto.getCreationDate();
        this.modifiedDate=toDoListRequestDto.getModifiedDate();
    }

    public void update(ToDoListRequestDto requestDto) {
        this.managerName=requestDto.getManagerName();
        this.toDoListContents=requestDto.getToDoListContents();
        this.modifiedDate=requestDto.getModifiedDate();
    }
}
