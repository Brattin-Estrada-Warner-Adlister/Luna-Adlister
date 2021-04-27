package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    // Insert a new ad and return the new ad's id
    Long insert(Ad ad);
    void delete(long adId);


    // insert a new ad and return the new ad's id
    default Long insert() {
        return insert();
    }

    // insert a new ad and return the new ad's id
//    Long insert(Ad ad);
    Ad getAdById(Long id);
    void updateAd(Ad ad);
    int delete(Long id);
    List<Ad> searchAds(String searchTerm);

    List<Ad> searchAdsFromResults(String searchAds);
}
