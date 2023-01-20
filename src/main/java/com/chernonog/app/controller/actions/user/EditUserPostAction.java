package com.chernonog.app.controller.actions.user;

import com.chernonog.app.controller.Action;
import com.chernonog.app.model.User;
import com.chernonog.app.service.UserService;
import com.chernonog.app.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EditUserPostAction implements Action {
    UserService userService = new UserServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        userService.updateUser(req);

        return HOME;
    }
}
