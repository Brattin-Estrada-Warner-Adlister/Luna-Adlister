USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;

CREATE TABLE IF EXISTS users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       user_name VARCHAR(255) NOT NULL,
                       date_posted CREATED_AT,
                       category TEXT,
                       description  LONGTEXT,
                       location VARCHAR(255),
                       PRIMARY KEY (id)

);

CREATE TABLE IF EXISTS ad_list (
                     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                     user_id INT UNSIGNED NOT NULL,
                     title VARCHAR(240) NOT NULL,
                     description TEXT NOT NULL,
                     PRIMARY KEY (id),
                     FOREIGN KEY (user_id) REFERENCES users(id)
                         ON DELETE CASCADE

);

CREATE TABLE categories (
                           id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                           name VARCHAR(100) NOT NULL,
                           PRIMARY KEY (id)
);


CREATE TABLE ads_categories (
                               ads_id INT UNSIGNED DEFAULT NULL,
                               categories_id INT UNSIGNED DEFAULT NULL,
                               FOREIGN KEY (ads_id)
                                   REFERENCES ads(id),
                               FOREIGN KEY (categories_id)
                                   REFERENCES categories(id)
);