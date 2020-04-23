package com.internet.shop.model;

import java.util.List;

public class Order {
    private Long id;
    private List<Product> productList;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
