package com.chernonog.app.controller.actions;

import com.chernonog.app.controller.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomePageAction implements Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println(req.getSession().getAttribute("login"));
        return HOME;
    }
}
