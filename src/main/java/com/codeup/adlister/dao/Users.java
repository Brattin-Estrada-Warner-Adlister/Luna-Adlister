package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> 2db44e94fa71e1ae2ce8bb0ff14f10aed34e3502

public interface Users {
    ArrayList<User>all();
    User findByUsername(String username);
    Long insert(User user);
    int updateUser(User user);
    int deleteUser(long id);
}