//package com.codeup.adlister.dao;
//
//
//import com.codeup.adlister.models.AdCategory;
//import com.mysql.cj.jdbc.Driver;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class MySQLAdsCategoriesDao extends AdsCategories{
//    private Connection connection = null;
//
//    public MySQLAdsCategoriesDao(Config config) {
//        try {
//            DriverManager.registerDriver(new Driver());
//            connection = DriverManager.getConnection(
//                    config.getUrl(),
//                    config.getUser(),
//                    config.getPassword()
//            );
//        } catch (SQLException e) {
//            throw new RuntimeException("Error connecting to the database", e);
//        }
//    }
//
//
//    public Long create (AdsCategories adsCategories) {
//        return null;
//    }
//
//
//    public int update(AdsCategories adsCategories) {
//        return 0;
//    }
//}
