package com.chernonog.app.controller.filters;

import com.chernonog.app.model.Role;
import com.chernonog.app.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter({"/pages/admin/*", "/pages/speaker/*"})
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        User user = (User) req.getSession().getAttribute("user");

        if (req.getPathInfo().contains("admin")) {
            if (user != null && user.getRole() == Role.MODERATOR) {
                System.out.println("ACCESS ALLOWED FOR USER " + user.getLogin());
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                resp.sendRedirect(req.getContextPath() + "/pages/error");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
