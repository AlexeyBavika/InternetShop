package com.internet.shop;

import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.service.ProductService;
import java.math.BigDecimal;

public class Main {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);
        initializeDatabase(productService);
        System.out.println("Products : ");
        System.out.println(productService.getAllProducts());
        System.out.println("First product with new price 1600 : ");
        Product productToUpdate = productService.getProduct(1L);
        productToUpdate.setPrice(BigDecimal.valueOf(1600));
        productService.update(productToUpdate);
        System.out.println(productService.getProduct(1L));
        System.out.println("Products after deleting third one : ");
        productService.delete(3L);
        System.out.println(productService.getAllProducts());
    }

    private static void initializeDatabase(ProductService productService) {
        Product product1 = new Product("Bmv", new BigDecimal(1500));
        Product product2 = new Product("Audi", new BigDecimal(1400));
        Product product3 = new Product("Honda", new BigDecimal(1700));
        productService.create(product1);
        productService.create(product2);
        productService.create(product3);

    }
}
