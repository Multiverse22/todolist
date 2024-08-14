package com.sparta.todolist.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ToDoListRequestDto {
    private int id;
    private String managerName;
    private String toDoListContents;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp creationDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp modifiedDate;
    private String password;
}
