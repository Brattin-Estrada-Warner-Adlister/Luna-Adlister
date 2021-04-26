package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.AdCategory;
import java.sql.SQLException;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
<<<<<<< HEAD
    // Insert a new ad and return the new ad's id
    Long insert(Ad ad);
    void delete(long adId);
=======
    // insert a new ad and return the new ad's id
    Long insert(Ad ad, String[] categories); //Should fix functionality for ads
    Ad getAdById(Long id);
    void editAd(Ad ad, String[] categories);
    int delete(Long adId);
>>>>>>> b20834dbafd7f090a589a36ba90e70d98ce04a0a
    List<Ad> searchAdsFromResults(String searchAds) throws SQLException;
    //List<Ad> searchAds category? search all? (String , String
    void insertAdCategory(AdCategory adCategory);

    Long insert(Ad ad);
}