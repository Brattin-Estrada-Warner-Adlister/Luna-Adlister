USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       username VARCHAR(240) NOT NULL,
                       email VARCHAR(240) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       PRIMARY KEY (id)
);

CREATE TABLE ads (
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
