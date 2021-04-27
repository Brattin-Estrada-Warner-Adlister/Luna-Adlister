package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;
import java.sql.SQLException;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    void delete(long adId);

    void editAd(Ad beforeAd, Ad afterAd) throws SQLException;

    List<Ad> searchAdsFromResults(String searchAds) throws SQLException;

    Object searchAdsByUser(long id);

    Object findAdById(long adId);
}
