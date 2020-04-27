package com.internet.shop;

import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.model.User;
import com.internet.shop.service.OrderService;
import com.internet.shop.service.ProductService;
import com.internet.shop.service.ShoppingCartService;
import com.internet.shop.service.UserService;
import java.math.BigDecimal;

public class Main {
    private static Injector injector = Injector.getInstance("com.internet.shop");

    public static void main(String[] args) {
        var productService = (ProductService) injector.getInstance(ProductService.class);
        Product bmv = new Product("Bmv", new BigDecimal(1500));
        Product audi = new Product("Audi", new BigDecimal(2000));
        Product bugatti = new Product("Bugatti", new BigDecimal(3000));
        Product toDelete = new Product("CarToDelete", new BigDecimal(0));
        productService.create(bmv);
        productService.create(audi);
        productService.create(bugatti);
        productService.create(toDelete);
        System.out.println("All products : " + productService.getAll());
        System.out.println("Product with id 2 : " + productService.get(2L));
        productService.delete(toDelete.getId());
        System.out.println("All products after deleting last : "
                + productService.getAll());
        System.out.println("Modified price of product with id 1 : ");
        bmv.setPrice(new BigDecimal(1600));
        productService.update(bmv);
        System.out.println(productService.getAll() + "\n" + "\n");

        var userService = (UserService) injector.getInstance(UserService.class);
        User alexey = new User("Alexey", "alexx", "133");
        User vadim = new User("Vadim", "vadd", "133");
        User matvey = new User("Matvey", "matt", "133");
        User usertoDelete = new User("delete", "delete", "1");
        userService.create(alexey);
        userService.create(vadim);
        userService.create(matvey);
        userService.create(usertoDelete);
        System.out.println("All users : " + userService.getAll());
        System.out.println("User with id 2 : " + userService.get(2L));
        userService.delete(usertoDelete.getId());
        System.out.println("All users after deleting last : " + userService.getAll());
        alexey.setLogin("Alex229");
        userService.update(alexey);
        System.out.println("Users with first user modified login : " + userService.getAll()
                + "\n\n");

        var shoppingCartService = (ShoppingCartService) injector
                .getInstance(ShoppingCartService.class);
        ShoppingCart shoppingCart = shoppingCartService.getByUserId(alexey.getId());
        shoppingCartService.addProduct(shoppingCart, bmv);
        shoppingCartService.addProduct(shoppingCart, audi);
        shoppingCartService.addProduct(shoppingCart, bugatti);
        System.out.println("Shopping cart : "
                + shoppingCartService.getAllProducts(shoppingCart));

        var orderService = (OrderService) injector.getInstance(OrderService.class);
        orderService.completeOrder(shoppingCartService.getAllProducts(shoppingCart),
                alexey);
        System.out.println("Shopping cart after completed order : " + shoppingCartService
                .getAllProducts(shoppingCart));
        System.out.println("Alexey order : " + orderService.getUserOrders(alexey));
    }
}
