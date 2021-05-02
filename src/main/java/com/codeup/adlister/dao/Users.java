package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Users {
<<<<<<< HEAD
    ArrayList<User>all();
=======

>>>>>>> 6abc6c11886d49f8c29a123b3da2f261ce6af2b4
    User findByUsername(String username);

    Long insert(User user);
<<<<<<< HEAD
    int editUser(User user);
    int deleteUser(long id);

    void updateUser(User user);
=======

    void deleteUser(long userId);

    void editUser(User user) throws SQLException;

    User findUserById(long id) throws SQLException;

    List<User> all();
>>>>>>> 6abc6c11886d49f8c29a123b3da2f261ce6af2b4
}