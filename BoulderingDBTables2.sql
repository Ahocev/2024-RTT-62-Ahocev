CREATE TABLE locations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100),
    city VARCHAR(100),
    state VARCHAR(100),
    gps VARCHAR(255)
);

CREATE TABLE zones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location_id INT,
    name VARCHAR(255),
    FOREIGN KEY (location_id) REFERENCES locations(id)
);

CREATE TABLE boulders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    zone_id INT,
    name VARCHAR(255),
    FOREIGN KEY (zone_id) REFERENCES zones(id)
);

CREATE TABLE boulder_problems (
    id INT AUTO_INCREMENT PRIMARY KEY,
    boulder_id INT,
    name VARCHAR(255),
    rating INT,
    grade VARCHAR(50),
    repeated BOOLEAN,
    history VARCHAR(5000),
    first_ascensionist VARCHAR(255),
    posted_by INT,
    showcase_img_url VARCHAR(255),
    FOREIGN KEY (boulder_id) REFERENCES boulders(id),
    FOREIGN KEY (posted_by) REFERENCES users(id)
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(150) UNIQUE,
    password VARCHAR(150),
    name VARCHAR(200),
    age INT,
    ape_index FLOAT,
    height FLOAT,
    gender VARCHAR(50),
    about VARCHAR(2000),
    profile_img_url VARCHAR(255)
);

CREATE TABLE comments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    comment VARCHAR(2000),
    date DATE,
    likes INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE boulder_problem_comments (
    boulder_problem_id INT,
    comment_id INT,
    PRIMARY KEY (boulder_problem_id, comment_id),
    FOREIGN KEY (boulder_problem_id) REFERENCES boulder_problems(id),
    FOREIGN KEY (comment_id) REFERENCES comments(id)
);