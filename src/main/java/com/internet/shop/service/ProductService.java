package com.internet.shop.service;

import com.internet.shop.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product create(Product product);

    Optional<Product> getProduct(Long id);

    List<Product> getAllProducts();

    Product update(Product product);

    boolean delete(Long id);
}
