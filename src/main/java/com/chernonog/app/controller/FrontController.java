package com.chernonog.app.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet("/pages/*")
public class FrontController extends HttpServlet {

    private static final String PATH = "/WEB-INF/jsp/";

    @SneakyThrows
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());
        Action action = ActionFactory.getAction(req);
        String view = action.execute(req, resp);

        if (view.equals(req.getPathInfo().substring(1))) {
            req.getRequestDispatcher(PATH + view + ".jsp").forward(req, resp);
        } else {
            resp.sendRedirect(view);
        }
    }
}
