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