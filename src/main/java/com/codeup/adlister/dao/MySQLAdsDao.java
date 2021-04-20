package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public class MySQLAdsDao implements Ads {
  public MySQLAdsDao(Config config) {
  }

  @Override
  public List<Ad> all() {
    return null;
  }

  @Override
  public Long insert(Ad ad) {
    return null;
  }
}
