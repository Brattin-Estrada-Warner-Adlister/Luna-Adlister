CREATE TABLE users (
                       id INT UNSIGNED AUTO_INCREMENT,
                       email VARCHAR(100) NOT NULL,
                       username VARCHAR(100) NOT NULL,
                       password VARCHAR(200) NOT NULL,
                       dateMade VARCHAR(50) NOT NULL,
                       PRIMARY KEY(id),
                       UNIQUE (username),
                       UNIQUE (email)
);

CREATE TABLE ads (
                     id INT UNSIGNED AUTO_INCREMENT,
                     user_id INT UNSIGNED NOT NULL,
                     title VARCHAR(200) NOT NULL,
                     description VARCHAR(500) NOT NULL,
                     dateMade VARCHAR(50) NOT NULL,
                     catString VARCHAR(255) NOT NULL,
                     PRIMARY KEY(id),
                     FOREIGN KEY (user_id) REFERENCES users(id),
                     UNIQUE (user_id, title, description)
);

CREATE TABLE categories (
                            id INT UNSIGNED AUTO_INCREMENT,
                            category VARCHAR(100) NOT NULL,
                            PRIMARY KEY(id),
                            UNIQUE (category)
);

CREATE TABLE adCategories (
                              ad_id INT UNSIGNED NOT NULL,
                              category_id INT UNSIGNED NOT NULL,
                              FOREIGN KEY (ad_id) REFERENCES ads(id),
                              FOREIGN KEY (category_id) REFERENCES categories(id)
);

INSERT INTO categories (category) VALUES
('sports'),
('camping'),
('computers'),
('phones'),
('jobs'),
('clothing'),
('cars'),
('furniture'),
('other');