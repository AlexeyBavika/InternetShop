package com.internet.shop.dao;

import com.internet.shop.model.ShoppingCart;
import java.util.List;
import java.util.Optional;

public interface ShoppingCartDao {

    ShoppingCart createShoppingCart(ShoppingCart shoppingCart);

    Optional<ShoppingCart> getShoppingCart(Long id);

    List<ShoppingCart> getAllShoppingCarts();

    ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

    boolean deleteShoppingCart(Long id);
}
