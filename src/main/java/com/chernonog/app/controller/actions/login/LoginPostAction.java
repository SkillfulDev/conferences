package com.chernonog.app.controller.actions.login;

import com.chernonog.app.config.DataSource;
import com.chernonog.app.controller.Action;
import com.chernonog.app.model.User;
import com.chernonog.app.service.UserService;
import com.chernonog.app.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPostAction implements Action {

    private UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = userService.getUserByLoginAndPassword(login, password);
        req.getSession().setAttribute("user", user);

        System.out.println("Authorized user: " + req.getSession().getAttribute("user"));

        return req.getContextPath() + "/pages/home";
    }
}
