package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.ArrayList;
import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    void delete(long adId);
    Ad getAdById(Long id);
    void editAd(Ad ad);
    List<Ad> userAds(long userId);
    List<Ad> searchAds(String searchTerm);

}