package com.codeup.adlister.dao;

import com.codeup.adlister.models.AdCategory;

import java.util.ArrayList;

public interface AdsCategories {
    Long create(AdCategory adCategory);
    int update(AdCategory adCategory);
}
