package com.internet.shop.dao;

import com.internet.shop.model.Product;
import java.util.Optional;

public interface ProductDao {

    Product create(Product product);

    Optional<Product> get(Long id);

    Product update(Product product);

    boolean delete(Long id);

}
