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
    List<Ad> allAds = new ArrayList<>();
    PreparedStatement stmt1 = null;
    try {
      String query1 = "select * from ads";
      stmt1 = connection.prepareStatement(query1);
      ResultSet rs = stmt1.executeQuery();
      long adId;
      while (rs.next()) {
        long id = rs.getLong("id");
        Ad ad = new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
        allAds.add(ad);
      }
      return allAds;
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
      long adId = rs.getLong(1);

      return adId;
    } catch (SQLException e) {
      throw new RuntimeException("Error creating a new ad.", e);
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
    Ad found = new Ad();
    try {
      String query = "select * from ads where id = ?";
      PreparedStatement stmt = connection.prepareStatement(query);
      stmt.setString(1, String.valueOf(id));

      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
        found.setId(id);
        found.setUserId(rs.getLong("user_id"));
        found.setTitle(rs.getString("title"));
        found.setDescription(rs.getString("description"));
      }
    } catch (SQLException ex) {
      System.out.printf("ERROR: %s\n", ex);
    }
    return found;
  }

  @Override
  public void editAd(Ad ad) {
    try {
      delete(ad.getId());
      insert(ad);

    } catch (Exception ex) {
      System.out.printf("ERROR: %s\n", ex);
    }

  }

  @Override
  public int delete(Long id) {
    int numberOfRowsAffected = 0;
    try {
      String deleteQuery = "delete from ads where id = ? ";
      PreparedStatement stmtDelete = connection.prepareStatement(deleteQuery);
      stmtDelete.setLong(1, id);
      numberOfRowsAffected = stmtDelete.executeUpdate();
    } catch (SQLException ex) {
      System.out.printf("ERROR: %s\n", ex);
    }
    return numberOfRowsAffected;
  }

  @Override
  public List<Ad> searchAds(String searchTerm) {
    List<Ad> filteredAds = new ArrayList<>();
    try {
      String query = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ?";
      PreparedStatement stmtSearch = connection.prepareStatement(query);
      stmtSearch.setString(1, '%' + searchTerm + '%');
      stmtSearch.setString(2, '%' + searchTerm + '%');
      ResultSet rs = stmtSearch.executeQuery();
      while (rs.next()) {
        Ad ad = new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
        filteredAds.add(ad);
      }
    } catch (SQLException e) {
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
