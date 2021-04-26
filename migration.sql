USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS ads_categories;

CREATE TABLE IF EXISTS users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,

                       user_name VARCHAR(255) NOT NULL,
                       date_posted CREATED_AT,
                       category TEXT,
                       description  LONGTEXT,
                       location VARCHAR(255),

                       username VARCHAR(240) UNIQUE NOT NULL,
                       email VARCHAR(240) NOT NULL,
                       password VARCHAR(255) NOT NULL,

 
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

SELECT * FROM ads WHERE title LIKE '%anytext%' OR description LIKE '%anytext%';

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
#                                    ON DELETE CASCADE,
                               FOREIGN KEY (categories_id)
                                   REFERENCES categories(id)

);

#                                     ON DELETE CASCADE,
);

SHOW TABLES;


INSERT INTO categories (name) VALUES
('junior'),
('mid'),
('senior'),
('front'),
('back'),
('full'),
('java'),
('javascript'),
('html'),
('css'),
('develop'),
('codeup');

SELECT * FROM categories;

SHOW DATABASES ;
USE adlister_db;
SHOW TABLES;

SELECT * FROM users;
SELECT * FROM ads;
SELECT * FROM ads_categories;
SELECT * FROM categories;
