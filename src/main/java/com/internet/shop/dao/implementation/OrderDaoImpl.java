package com.internet.shop.dao.implementation;

import com.internet.shop.dao.OrderDao;
import com.internet.shop.db.Storage;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.Order;
import com.internet.shop.model.User;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public Order create(Order order) {
        Storage.orders.add(order);
        return order;
    }

    @Override
    public Optional<Order> get(Long orderId) {
        return Storage.orders.stream()
                .filter(order -> order.getId().equals(orderId))
                .findFirst();
    }

    @Override
    public List<Order> getAll() {
        return Storage.orders;
    }

    @Override
    public Order update(Order order) {
        Order orderToUpdate = get(order.getId()).get();
        orderToUpdate.setUser(order.getUser());
        orderToUpdate.setProductList(order.getProductList());
        return orderToUpdate;
    }

    @Override
    public boolean delete(Long orderId) {
        return Storage.orders.removeIf(order -> order.getId().equals(orderId));
    }

    @Override
    public List<Order> getUserOrders(User user) {
        return getAll().stream()
                .filter(order -> order.getUser().equals(user))
                .collect(Collectors.toList());
    }
}
