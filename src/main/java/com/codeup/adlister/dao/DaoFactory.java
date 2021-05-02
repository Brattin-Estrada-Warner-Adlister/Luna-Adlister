package com.codeup.adlister.dao;


public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

<<<<<<< HEAD
    public static AdsCategories getAdsCategoriesDao(){
        if(adsCategoriesDao == null) {
            adsCategoriesDao = new MySQLAdsCategoriesDao(config);
        }
        return adsCategoriesDao;
    }
}
=======
}
>>>>>>> 6abc6c11886d49f8c29a123b3da2f261ce6af2b4
