package com.internet.shop.dao.implementation;

import com.internet.shop.dao.ProductDao;
import com.internet.shop.dao.Storage;
import com.internet.shop.lib.Dao;
import com.internet.shop.model.Product;
import java.util.NoSuchElementException;
import java.util.Optional;

@Dao
public class ProductDaoImpl implements ProductDao {

    @Override
    public Product create(Product product) {
        Storage.addProduct(product);
        return product;
    }

    @Override
    public Optional<Product> get(Long id) {
        return Optional.ofNullable(Storage.products.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can`t find item with id " + id)));
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
