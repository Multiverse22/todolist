package com.sparta.todolist.repository;

import com.sparta.todolist.dto.ToDoListRequestDto;
import com.sparta.todolist.dto.ToDoListResponseDto;
import com.sparta.todolist.entity.ToDoList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class ToDoListRepository {

    private final JdbcTemplate jdbcTemplate;

    public ToDoListRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ToDoList save(ToDoList toDoList) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO todolist (manager, todo, creationDate,modifyDate,password) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, toDoList.getManagerName());
            preparedStatement.setString(2, toDoList.getToDoListContents());
            preparedStatement.setDate(3, Date.valueOf(toDoList.getCreationDate()));
            preparedStatement.setDate(4, Date.valueOf(toDoList.getModifyDate()));
            preparedStatement.setString(5, toDoList.getPassword());
            return preparedStatement;
        }, keyHolder);

        int id = keyHolder.getKey().intValue();
        toDoList.setId(id);

        return toDoList;
    }


    public List<ToDoListResponseDto> findAll() {
        //DB조회
        String sql = "SELECT * FROM todolist";

        return jdbcTemplate.query(sql,new RowMapper<ToDoListResponseDto>() {
            @Override
            public ToDoListResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {

                int id = rs.getInt("id");
                String managerName = rs.getString("manager");
                String todo = rs.getString("todo");
                LocalDate creationDate = rs.getDate("creationDate").toLocalDate();
                LocalDate modifyDate = rs.getDate("modifyDate").toLocalDate();
                String password = rs.getString("password");
                return new ToDoListResponseDto(id,managerName,todo,creationDate,modifyDate,password);
            }
        });
    }

    public void delete(int id) {
        String sql = "DELETE FROM TODOLIST WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    public ToDoList findById(int id) {
        String sql = "SELECT * FROM TODOLIST WHERE id = ?";

        return jdbcTemplate.query(sql,resultSet -> {
            if(resultSet.next()) {
                ToDoList toDoList = new ToDoList();
                toDoList.setId(resultSet.getInt("id"));
                toDoList.setManagerName(resultSet.getString("manager"));
                toDoList.setToDoListContents(resultSet.getString("toDoListContents"));
                toDoList.setCreationDate(resultSet.getDate("creationDate").toLocalDate());
                toDoList.setModifyDate(resultSet.getDate("modifyDate").toLocalDate());
                return toDoList;
            } else {
                return null;
            }
        },id);
    }

    public void update(int id, ToDoListRequestDto requestDto) {
        String sql = "UPDATE todolist SET manager = ?,toDoListContents = ?,modifyDate = ? WHERE id =?";
        jdbcTemplate.update(sql,requestDto.getManagerName(),requestDto.getToDoListContents(),requestDto.getModifyDate());
    }

}
