package com.internet.shop.dao.implementation;

import com.internet.shop.dao.OrderDao;
import com.internet.shop.db.Storage;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.Order;
import java.util.List;
import java.util.Optional;

@Dao
public class OrderDaoImpl implements OrderDao {

    @Override
    public Order createOrder(Order order) {
        Storage.orders.add(order);
        return order;
    }

    @Override
    public Optional<Order> getOrder(Long orderId) {
        return Storage.orders.stream()
                .filter(order -> order.getId().equals(orderId))
                .findFirst();
    }

    @Override
    public List<Order> getAllOrders() {
        return Storage.orders;
    }

    @Override
    public Order updateOrder(Order order) {
        Order orderToUpdate = getOrder(order.getId()).get();
        orderToUpdate.setUser(order.getUser());
        orderToUpdate.setProductList(order.getProductList());
        return orderToUpdate;
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        return Storage.orders.removeIf(order -> order.getId().equals(orderId));
    }
}
