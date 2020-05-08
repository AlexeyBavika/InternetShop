package com.internet.shop.filter;

import com.internet.shop.lib.Injector;
import com.internet.shop.model.Role;
import com.internet.shop.model.User;
import com.internet.shop.service.UserService;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {
    private static final String USER_ID = "user_id";
    private static final Injector INJECTOR = Injector.getInstance("com.internet.shop");
    private static final Logger LOGGER = Logger.getLogger(AuthorizationFilter.class);
    private final UserService userService = (UserService) INJECTOR.getInstance(UserService.class);
    private Map<String, List<Role.RoleName>> urls = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        urls.put("/allUsers", List.of(Role.RoleName.ADMIN));
        urls.put("/deleteUser", List.of(Role.RoleName.ADMIN));
        urls.put("/editProducts", List.of(Role.RoleName.ADMIN));
        urls.put("/deleteProduct", List.of(Role.RoleName.ADMIN));
        urls.put("/addProduct", List.of(Role.RoleName.ADMIN));
        urls.put("/completeOrder", List.of(Role.RoleName.USER));
        urls.put("/getAllOrders", List.of(Role.RoleName.USER));
        urls.put("/getOrder", List.of(Role.RoleName.USER));
        urls.put("/shoppingCart", List.of(Role.RoleName.USER));
        urls.put("/addProductToShoppingCart", List.of(Role.RoleName.USER));
        urls.put("/deleteProductFromShoppingCart", List.of(Role.RoleName.USER));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getServletPath();
        if (urls.get(url) == null) {
            filterChain.doFilter(request, response);
            return;
        }
        Long userId = (Long) request.getSession().getAttribute(USER_ID);
        if (userId == null || userService.get(userId) == null) {
            response.sendRedirect("/login");
            return;
        }
        User user = userService.get(userId);
        if (isAuthorized(user, urls.get(url))) {
            filterChain.doFilter(request, response);
        } else {
            LOGGER.warn("User access denied to url " + url);
            request.getRequestDispatcher("/WEB-INF/view/accessDenied.jsp")
                    .forward(request, response);
        }
    }

    @Override
    public void destroy() {

    }

    private boolean isAuthorized(User user, List<Role.RoleName> authorizedRoles) {
        for (Role.RoleName authorizedRole : authorizedRoles) {
            for (Role userRole : user.getRoles()) {
                if (authorizedRole.equals(userRole.getRoleName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
