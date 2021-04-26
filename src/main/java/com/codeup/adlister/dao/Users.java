package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import java.util.ArrayList;
import java.util.List;

public interface Users {
    ArrayList<User>all();
    User findByUsername(String username);
    Long insert(User user);
    int editUser(User user);
    int deleteUser(long id);

    void updateUser(User user);
}