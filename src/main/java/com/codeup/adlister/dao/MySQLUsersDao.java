package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    @Override
    public void deleteUser(User user) {

    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }


    public void deleteUser(long userID) {
        try {
            String query = "DELETE FROM users WHERE id=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, userID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("No user match.", e);
        }
    }

    @Override
    public void editUser(User user)  {
        String updatedUser = "UPDATE users SET username=?, email=? where id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(updatedUser);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setLong(3, user.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't update profile", e);
        }
    }


//    public void editUser(User oldUser, User newUser) throws SQLException {
//        String updateUserQuery = ("Update users set username = ?, email = ? where username = ?");
//        try {
//            PreparedStatement stmt = connection.prepareStatement(updateUserQuery);
//            stmt.setString(1, newUser.getUsername());
//            stmt.setString(2, newUser.getEmail());
//            stmt.setString(3, oldUser.getUsername());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException("Can't update profile", e);
//        }
//    }


    public User findUserById(long id) {
        String query = ("SELECT * FROM users WHERE id = ? LIMIT 1");
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Can't find user by id", e);
        }
    }

    @Override
    public List<User> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = stmt.executeQuery();
            return createUserFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving Users", e);
        }
    }

    private List<User> createUserFromResults(ResultSet rs) throws SQLException {
        List<User> user = new ArrayList<>();
        while (rs.next()) {
            user.add(extractUser(rs));
        }
        return user;

    }

}

