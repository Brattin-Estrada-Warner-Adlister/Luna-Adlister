package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Users {

    User findByUsername(String username);

    Long insert(User user);

    void deleteUser(long userId);

    void editUser(User user) throws SQLException;

    User findUserById(long id) throws SQLException;

    List<User> all();
}