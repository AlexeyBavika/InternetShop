package com.internet.shop.model;

import java.util.List;

public class Order {
    private Long id;
    private List<Product> productList;
    private User user;

    public Order(User user, List<Product> products) {
        this.user = user;
        this.productList = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
