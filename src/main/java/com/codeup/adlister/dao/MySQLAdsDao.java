package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

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
        System.out.println(ad);
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

    @Override
    public void delete(long id) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("DELETE FROM ads WHERE id='" + id + "'");
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad.");
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

    public void editAd(Ad beforeAd, Ad afterAd) throws SQLException {
        String updateQuery = ("update ads set title = ?, description = ? where id = ?");
        try {
            PreparedStatement stmt = connection.prepareStatement(updateQuery);
            stmt.setString(1, afterAd.getTitle());
            stmt.setString(2, afterAd.getDescription());
            stmt.setLong(3, beforeAd.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Can't update ad", e);
        }
    }

    @Override
    public List<Ad> searchAdsFromResults(String searchAds) throws SQLException {
        return null;
    }

    //@Override
    public Ad searchByTitle(String title) {
        String query = "SELECT * FROM ads where title = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, title);
            ResultSet rs = stmt.executeQuery();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error searching for ad by title");
        }
    }

    public Ad searchAdById(long id) {
        String query = ("select * from ads where id = ? limit 1");
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extractAd(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Can't find ad by id", e);
        }
    }

    //@Override
    public List<Ad> searchAdsByInput(String searchInput) throws SQLException {
        try {
            String searchQuery = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
            String searchQueryPlus = "%" + searchInput + "%";
            PreparedStatement stmt = connection.prepareStatement(searchQuery);
            stmt.setString(1, searchQueryPlus);
            stmt.setString(2, searchQueryPlus);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("No ads match your search.", e);
        }
    }

    @Override
    public List<Ad> searchAdsByUser(long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id=?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);

        }
    }

    @Override
    public Object findAdById(long adId) {
        return null;
    }
}