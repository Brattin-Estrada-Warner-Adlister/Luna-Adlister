package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;
import com.mysql.cj.jdbc.Driver;

public class MySQLUsersDao implements Users {
    private final Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver() {
              @Override
              public Connection connect(String url, Properties info) throws SQLException {
                return null;
              }

              @Override
              public boolean acceptsURL(String url) throws SQLException {
                return false;
              }

              @Override
              public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
                return new DriverPropertyInfo[0];
              }

              @Override
              public int getMajorVersion() {
                return 0;
              }

              @Override
              public int getMinorVersion() {
                return 0;
              }

              @Override
              public boolean jdbcCompliant() {
                return false;
              }

              @Override
              public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                return null;
              }
            });
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
    public ArrayList<User> all() {
        return null;
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
    public int editUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(long id) {
        return 0;
    }

    @Override
    public void updateUser(User user) {

    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

}
