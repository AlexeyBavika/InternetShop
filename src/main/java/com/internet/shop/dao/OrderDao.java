package com.internet.shop.dao;

import com.internet.shop.model.Order;
import java.util.List;
import java.util.Optional;

public interface OrderDao {

    Order createOrder(Order order);

    Optional<Order> getOrder(Long orderId);

    List<Order> getAllOrders();

    Order updateOrder(Order order);

    boolean deleteOrder(Long orderId);
}
