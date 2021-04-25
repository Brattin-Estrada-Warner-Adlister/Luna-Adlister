package com.codeup.adlister.dao;


import com.codeup.adlister.models.AdCategory;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLAdsCategoriesDao implements AdsCategories{
    private Connection connection = null;

    public MySQLAdsCategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    @Override
    public Long create (AdCategory adCategory) {
        return null;
    }

    @Override
    public int update(AdCategory adCategory) {
        return 0;
    }
}
