package com.internet.shop.db;

import com.internet.shop.model.Order;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.model.User;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<Product> products = new ArrayList<>();
    public static final List<ShoppingCart> shoppingCarts = new ArrayList<>();
    public static final List<User> users = new ArrayList<>();
    public static final List<Order> orders = new ArrayList<>();
    private static Long productId = 0L;
    private static Long bucketId = 0L;
    private static Long userId = 0L;
    private static Long ordersId = 0L;

    public static void addProduct(Product product) {
        productId++;
        product.setId(productId);
        products.add(product);
    }

    public static void addBucket(ShoppingCart shoppingCart) {
        bucketId++;
        shoppingCart.setId(bucketId);
        shoppingCarts.add(shoppingCart);
    }

    public static void addUser(User user) {
        userId++;
        user.setId(userId);
        users.add(user);
    }

    public static void addOrder(Order order) {
        ordersId++;
        order.setId(ordersId);
        orders.add(order);
    }
}