select * from employees;
select * from user_roles;
select * from users;
insert into user_roles ( user_id , role_name ) values ( 2, 'ADMIN' );
select * from user_roles;

CREATE TABLE locations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100),
    city VARCHAR(100),
    state VARCHAR(100),
    zone VARCHAR(100),
    gps VARCHAR(255)
);
select * from locations;
CREATE TABLE boulders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    location_id INT,
    rating INT,
    grade VARCHAR(50),
    repeated BOOLEAN,
    history VARCHAR(5000),
    first_ascensionist VARCHAR(255),
    posted_by INT,
    showcase_img_url VARCHAR(255),
    FOREIGN KEY (location_id) REFERENCES locations(id),
    FOREIGN KEY (posted_by) REFERENCES users(id)
);
CREATE TABLE comments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    comment VARCHAR(2000),
    date DATE,
    likes INT,
    FOREIGN KEY (user_id) REFERENCES users(id)
);
CREATE TABLE boulder_comments (
    boulder_id INT,
    comment_id INT,
    PRIMARY KEY (boulder_id, comment_id),
    FOREIGN KEY (boulder_id) REFERENCES boulders(id),
    FOREIGN KEY (comment_id) REFERENCES comments(id)
);

CREATE TABLE boulder_problems (
    id INT AUTO_INCREMENT PRIMARY KEY,      -- Primary key for boulder problems
    boulder_id INT,                         -- Foreign key linking to boulders
    name VARCHAR(255),
    rating INT,
    grade VARCHAR(50),
    repeated BOOLEAN,
    history VARCHAR(5000),
    first_ascensionist VARCHAR(255),
    posted_by INT,                          -- Foreign key linking to users
    showcase_img_url VARCHAR(255),
    FOREIGN KEY (boulder_id) REFERENCES boulders(id),    -- Establishing relationship to boulders
    FOREIGN KEY (posted_by) REFERENCES users(id)         -- Establishing relationship to users
);

CREATE TABLE boulders (
    id INT AUTO_INCREMENT PRIMARY KEY,      -- Primary key for boulders
    location_id INT,                        -- Foreign key linking to locations
    name VARCHAR(255),
    FOREIGN KEY (location_id) REFERENCES locations(id)  -- Establishing relationship to locations
);

CREATE TABLE comments (
    id INT AUTO_INCREMENT PRIMARY KEY,      -- Primary key for comments
    user_id INT,                            -- Foreign key linking to users
    comment VARCHAR(2000),
    date DATE,
    likes INT,
    FOREIGN KEY (user_id) REFERENCES users(id)  -- Establishing relationship to users
);

CREATE TABLE boulder_problem_comments (
    boulder_problem_id INT,                 -- Foreign key linking to boulder problems
    comment_id INT,                         -- Foreign key linking to comments
    PRIMARY KEY (boulder_problem_id, comment_id), -- Composite primary key
    FOREIGN KEY (boulder_problem_id) REFERENCES boulder_problems(id),  -- Establishing relationship to boulder problems
    FOREIGN KEY (comment_id) REFERENCES comments(id)                   -- Establishing relationship to comments
);