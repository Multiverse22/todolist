package com.sparta.todolist.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ToDoListRequestDto {
    private int id;
    private String managerName;
    private String toDoListContents;
    private LocalDate creationDate;
    private LocalDate modifyDate;
    private String password;
}
