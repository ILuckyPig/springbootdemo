package com.lu.service.impl;

import com.lu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("INSERT INTO user(name, age) values (?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE FROM user WHERE name =  ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM user", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("DELETE FROM user");
    }
}
