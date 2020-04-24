package com.internet.shop.dao.implementation;

import com.internet.shop.dao.ShoppingCartDao;
import com.internet.shop.db.Storage;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.ShoppingCart;
import java.util.List;
import java.util.Optional;

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
        ShoppingCart shoppingCartToUpdate = getShoppingCart(shoppingCart.getId()).get();
        shoppingCartToUpdate.setUser(shoppingCart.getUser());
        shoppingCartToUpdate.setProducts(shoppingCart.getProducts());
        return shoppingCartToUpdate;
    }

    @Override
    public boolean deleteShoppingCart(Long id) {
        return Storage.shoppingCarts.removeIf(shoppingCart -> shoppingCart.getId().equals(id));
    }
}
