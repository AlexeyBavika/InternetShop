DROP DATABASE IF EXISTS internet_shop;

CREATE DATABASE internet_shop;

USE internet_shop;

CREATE TABLE users
(
    id       INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name     VARCHAR(30)     NOT NULL,
    login    VARCHAR(30)     NOT NULL,
    password VARCHAR(30)     NOT NULL
);

CREATE TABLE roles
(
    id        INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    role_name VARCHAR(30)
);

CREATE TABLE users_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE products
(
    id    INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name  VARCHAR(30)     NOT NULL,
    price BIGINT(11)      NOT NULL
);

CREATE TABLE shopping_carts
(
    id      INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT             NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE shopping_carts_products
(
    cart_id    INT NOT NULL,
    product_id INT NOT NULL,
    FOREIGN KEY (cart_id) REFERENCES shopping_carts (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE orders
(
    id      INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT             NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE orders_products
(
    order_id   INT NOT NULL,
    product_id INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);

INSERT INTO users
    (name, login, password)
VALUES ("Adminovich", "admin", "1"),
       ("Alexey", "Alex", "1"),
       ("TestUser1", "Test1", "1"),
       ("TestUser2", "Test2", "1"),
       ("TestUser3", "Test3", "1");

INSERT INTO roles
    (role_name)
VALUES ("ADMIN"),
       ("USER");

INSERT INTO users_roles
    (user_id, role_id)
VALUES (1, 1),
       (2, 2),
       (3, 2);

INSERT INTO products
    (name, price)
VALUES ("Bmv", 1500),
       ("Audi", 1600),
       ("Bugatti", 2000);
