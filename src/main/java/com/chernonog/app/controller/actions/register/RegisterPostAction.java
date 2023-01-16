package com.chernonog.app.controller.actions.register;

import com.chernonog.app.controller.Action;
import com.chernonog.app.service.UserService;
import com.chernonog.app.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterPostAction implements Action {

    private UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        userService.saveUser(req);

        return req.getContextPath() + "/pages/login";
    }
}
