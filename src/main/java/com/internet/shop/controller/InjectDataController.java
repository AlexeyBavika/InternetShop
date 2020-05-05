package com.internet.shop.controller;

import com.internet.shop.lib.Injector;
import com.internet.shop.model.Role;
import com.internet.shop.model.User;
import com.internet.shop.service.UserService;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inject")
public class InjectDataController extends HttpServlet {
    private static final Injector INJECTOR = Injector.getInstance("com.internet.shop");
    private final UserService userService = (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User admin = new User("adminovich", "admin", "123",
                Set.of(Role.of("ADMIN")));
        User user = new User("Alexey", "Alex", "123", Set.of(Role.of("USER")));
        userService.create(admin);
        userService.create(user);
        req.getRequestDispatcher("/WEB-INF/view/inject.jsp").forward(req, resp);
    }
}
