package com.internet.shop.dao.implementation;

import com.internet.shop.dao.ShoppingCartDao;
import com.internet.shop.db.Storage;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.ShoppingCart;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Dao
public class ShoppingCartDaoImpl implements ShoppingCartDao {

    @Override
    public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
        Storage.addBucket(shoppingCart);
        return shoppingCart;
    }

    @Override
    public Optional<ShoppingCart> getShoppingCart(Long id) {
        return Storage.shoppingCarts.stream()
                .filter(shoppingCart -> shoppingCart.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<ShoppingCart> getAllShoppingCarts() {
        return Storage.shoppingCarts;
    }

    @Override
    public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
        IntStream.range(0, Storage.shoppingCarts.size())
                .filter(sc -> shoppingCart.getId().equals(Storage.shoppingCarts.get(sc).getId()))
                .forEach(i -> Storage.shoppingCarts.set(i, shoppingCart));
        return shoppingCart;
    }

    @Override
    public boolean deleteShoppingCart(Long id) {
        return Storage.shoppingCarts.removeIf(shoppingCart -> shoppingCart.getId().equals(id));
    }
}
