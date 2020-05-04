package com.internet.shop.controller.shoppingcart;

import com.internet.shop.lib.Injector;
import com.internet.shop.service.ShoppingCartService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/shoppingCart")
public class ShoppingCartController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("com.internet.shop");
    private final ShoppingCartService shoppingCartService =
            (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        req.setAttribute("products", shoppingCartService.getAllProducts(shoppingCartService
                .getByUserId(Long.valueOf(req.getSession().getAttribute("user_id").toString()))));
        req.getRequestDispatcher("/WEB-INF/view/shoppingcart/shoppingcart.jsp").forward(req, resp);
    }
}
