package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.AdCategory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListAdsDao implements Ads {
    private List<Ad> ads;

    public List<Ad> all() {
        if (ads == null) {
            ads = generateAds();
        }
        return ads;
    }

    public Long insert(Ad ad, String[] categories) {
        return null;
    }

    public Long insert(Ad ad) {
        if (ads == null) {
            ads = generateAds();
        }
        ad.setId((long) ads.size());
        ads.add(ad);
        return ad.getId();
    }

    @Override
    public void delete(long adId) {

    }

    @Override
    public Ad getAdById(Long id) {
        return null;
    }

    public void editAd(Ad ad, String[] categories) {

    }


    public void editAd(Ad ad) {
        ;
    }

    @Override
    public int delete(Long adId) {
        return 0;
    }

    public List<Ad> searchAdsFromResults(String searchAds) throws SQLException {
        return null;
    }

    public void insertAdCategory(AdCategory adCategory) {
        }



    private List<Ad> generateAds() {
        List<Ad> ads = new ArrayList<>();
        ads.add(new Ad(
                1,
                1,
                "playstation for sale",
                "This is a slightly used playstation"
        ));
        ads.add(new Ad(
                2,
                1,
                "Super Nintendo",
                "Get your game on with this old-school classic!"
        ));
        ads.add(new Ad(
                3,
                2,
                "Junior Java Developer Position",
                "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"
        ));
        ads.add(new Ad(
                4,
                2,
                "JavaScript Developer needed",
                "Must have strong Java skills"
        ));
        return ads;
    }
}