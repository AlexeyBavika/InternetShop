package com.internet.shop.controller.order;

import com.internet.shop.lib.Injector;
import com.internet.shop.service.OrderService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getOrder")
public class OrderController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("com.internet.shop");
    private final OrderService orderService = (OrderService) INJECTOR
            .getInstance(OrderService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        req.setAttribute("order", orderService.get(Long.valueOf(req.getParameter("order_id"))));
        req.getRequestDispatcher("/WEB-INF/view/order/order.jsp").forward(req, resp);
    }
}
