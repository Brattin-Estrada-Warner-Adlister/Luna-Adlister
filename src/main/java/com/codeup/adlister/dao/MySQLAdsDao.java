package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config config) {
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
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }
// INTELLIJ SUGGESTION
    @Override
    public void delete(long adId) {

    }

    @Override
    public List<Ad> userAds(long userId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = '" + userId + "'");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    @Override
    public Ad getAdById(Long id) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ? LIMIT 1");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs).get(0);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads.", e);
        }
    }


    @Override
    public void editAd(Ad ad) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("UPDATE ads SET title = ?, description = ? WHERE id = ?");
            stmt.setLong(1, ad.getId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating your ad");
        }
    }

    //@Override
    public void delete(Ad ad) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("DELETE FROM ads WHERE id = ?");
            stmt.setLong(1, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad.", e);
        }
    }

    @Override
    public List<Ad> searchAds(String searchTerm) {
        List<Ad> filteredAds = new ArrayList<>();
        try{
            String query = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
            PreparedStatement stmtSearch = connection.prepareStatement(query);
            stmtSearch.setString(1, '%' + searchTerm + '%');
            stmtSearch.setString(2, '%' + searchTerm + '%');
            ResultSet rs = stmtSearch.executeQuery();
            while(rs.next()){
                Ad ad = new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                );

                filteredAds.add(ad);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return filteredAds;
    }

    public static void main(String[] args) {
        Ads adsDao = new MySQLAdsDao(new Config());
        adsDao.delete(1L);
        List<Ad> all = adsDao.all();
        for (Ad ad : all) {
            System.out.println("id: " + ad.getId());
            System.out.println("Name: " + ad.getTitle());

        }

    }
}