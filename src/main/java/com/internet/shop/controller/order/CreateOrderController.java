package com.internet.shop.controller.order;

import com.internet.shop.lib.Injector;
import com.internet.shop.service.OrderService;
import com.internet.shop.service.ShoppingCartService;
import com.internet.shop.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createOrder")
public class CreateOrderController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("com.internet.shop");
    private final OrderService orderService = (OrderService) INJECTOR
            .getInstance(OrderService.class);
    private final UserService userService = (UserService) INJECTOR.getInstance(UserService.class);
    private final ShoppingCartService shoppingCartService = (ShoppingCartService) INJECTOR
            .getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        orderService.completeOrder(shoppingCartService
                .getByUserId(Long.valueOf(req.getParameter("user_id"))).getProducts(),
                userService.get(Long.valueOf(req.getParameter("user_id"))));
        resp.sendRedirect("/getAllOrders");
    }
}
