package com.example.springbootjdbcdemo.service;

import com.example.springbootjdbcdemo.entity.State;
import com.example.springbootjdbcdemo.entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @ResponseBody
    public List<User> getList(){
        String sql = "SELECT * FROM user";
        ObjectMapper mapper = new ObjectMapper();
        return jdbcTemplate.query(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User us = new User();
                us.setId(rs.getString("id"));
                us.setAge(rs.getString("age"));
                us.setName(rs.getString("name"));
                us.setSex(rs.getString("sex"));
                return us;
            }
        });
    }


    public String addUser(){
        String sql = "INSERT INTO user(id, name, age, sex) VALUE('2','bb','17','女')";
        jdbcTemplate.update(sql);
        return "add-ok";
    }

    public String updateUser(){
        String sql = "UPDATE user SET sex='未知' WHERE id = '2'";
        jdbcTemplate.update(sql);
        return "update-ok";
    }

    public String deleteUser(){
        String sql = "DELETE FROM user WHERE id = '2'" ;
        jdbcTemplate.update(sql);
        return "delete-ok";
    }
}
