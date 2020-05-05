package com.internet.shop.controller.shoppingcart;

import com.internet.shop.lib.Injector;
import com.internet.shop.service.ProductService;
import com.internet.shop.service.ShoppingCartService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteProductFromShoppingCart")
public class DeleteProductFromShoppingCartController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("com.internet.shop");
    private final ProductService productService = (ProductService) INJECTOR
            .getInstance(ProductService.class);
    private final ShoppingCartService shoppingCartService = (ShoppingCartService) INJECTOR
            .getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        shoppingCartService.deleteProduct(shoppingCartService
                        .getByUserId((Long)req.getSession().getAttribute("user_id")),
                productService.get(Long.valueOf(req.getParameter("product_id"))));
        resp.sendRedirect("/shoppingCart");
    }
}
