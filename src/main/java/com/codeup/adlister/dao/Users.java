package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import java.util.ArrayList;

public interface Users {
    ArrayList<User>all();
    User findByUsername(String username);
    Long insert(User user);
    int updateUser(User user);
    int deleteUser(long id);

}