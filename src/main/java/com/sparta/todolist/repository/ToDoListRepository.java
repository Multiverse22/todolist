package com.sparta.todolist.repository;

import com.sparta.todolist.dto.ToDoListRequestDto;
import com.sparta.todolist.dto.ToDoListResponseDto;
import com.sparta.todolist.entity.ToDoList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class ToDoListRepository {

    private final JdbcTemplate jdbcTemplate;

    public ToDoListRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ToDoList save(ToDoList toDoList) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO todo (toDoListContents, managerName, creationDate, modifiedDate, password) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, toDoList.getToDoListContents());
            preparedStatement.setString(2, toDoList.getManagerName());
            preparedStatement.setTimestamp(3,toDoList.getCreationDate());
            preparedStatement.setTimestamp(4, toDoList.getModifiedDate());
            preparedStatement.setString(5, toDoList.getPassword());
            return preparedStatement;
        }, keyHolder);

        int id = keyHolder.getKey().intValue();
        toDoList.setId(id);

        return toDoList;
    }


    public List<ToDoListResponseDto> findAll() {
        //DB조회
        String sql = "SELECT * FROM todo";

        return jdbcTemplate.query(sql,new RowMapper<ToDoListResponseDto>() {
            @Override
            public ToDoListResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {

                int id = rs.getInt("id");
                String managerName = rs.getString("managerName");
                String toDoListContents = rs.getString("toDoListContents");
                Timestamp creationDate = rs.getTimestamp("creationDate");
                Timestamp modifiedDate = rs.getTimestamp("modifiedDate");
                return new ToDoListResponseDto(id,managerName,toDoListContents,creationDate,modifiedDate);
            }
        });
    }

    public void delete(int id) {
        String sql = "DELETE FROM todo WHERE id = ?";
        jdbcTemplate.update(sql,id);
    }

    public ToDoList findById(int id) {
        String sql = "SELECT * FROM todo WHERE id = ?";

        return jdbcTemplate.query(sql,resultSet -> {
            if(resultSet.next()) {
                ToDoList toDoList = new ToDoList();
                toDoList.setId(resultSet.getInt("id"));
                toDoList.setManagerName(resultSet.getString("managerName"));
                toDoList.setToDoListContents(resultSet.getString("toDoListContents"));
                toDoList.setCreationDate(resultSet.getTimestamp("creationDate"));
                toDoList.setModifiedDate(resultSet.getTimestamp("modifiedDate"));
                return toDoList;
            } else {
                return null;
            }
        },id);
    }

    public void update(int id, ToDoListRequestDto requestDto) {
        String sql = "UPDATE todolist SET managerName = ?,toDoListContents = ?,modifiedDate = ? WHERE id =?";
        jdbcTemplate.update(sql,requestDto.getManagerName(),requestDto.getToDoListContents(),requestDto.getModifiedDate());
    }

}
