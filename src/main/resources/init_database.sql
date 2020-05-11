DROP DATABASE IF EXISTS internet_shop;

CREATE DATABASE internet_shop;

USE internet_shop;

CREATE TABLE products (
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
price BIGINT(11) NOT NULL
);

INSERT INTO products
(name, price)
VALUES
("Bmv", 1500),
("Audi", 1600),
("Bugatti", 2000);