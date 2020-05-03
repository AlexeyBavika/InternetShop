package com.internet.shop.filter;

import com.internet.shop.lib.Injector;
import com.internet.shop.service.UserService;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {
    private static final String USER_ID = "user_id";
    private static final Injector INJECTOR = Injector.getInstance("com.internet.shop");
    private final UserService userService = (UserService) INJECTOR.getInstance(UserService.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Long userId = (Long) request.getSession().getAttribute(USER_ID);

        String url = request.getServletPath();
        if (url.equals("/login") || url.equals("/register")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (userId == null || userService.get(userId) == null) {
            response.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
