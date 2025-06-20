CREATE DATABASE cms;
USE cms;

CREATE TABLE users(
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      firstName VARCHAR(50) NOT NULL UNIQUE,
                      lastName VARCHAR(20),
                      address VARCHAR(100) NOT NULL,
                      username VARCHAR(20),
                      password VARCHAR(20),
                      role VARCHAR(20)
);

CREATE TABLE complains(
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          complain VARCHAR(5000),
                          status VARCHAR(50)
);