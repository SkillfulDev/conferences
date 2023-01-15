package com.chernonog.app.controller.actions;

import com.chernonog.app.config.ConnectionConfig;
import com.chernonog.app.config.DataSource;
import com.chernonog.app.controller.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.ResultSet;
import java.sql.Statement;

public class LoginPostAction implements Action {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            Statement statement = ConnectionConfig.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user where login = '" + login +
                    "'and password='" + password + "'");

            if (resultSet.next()) {
                req.getSession().setAttribute("id", resultSet.getInt("id"));
                req.getSession().setAttribute("password", password);
                req.getSession().setAttribute("login", login);
                req.getSession().setAttribute("role", resultSet.getString("role"));

                //TODO почему бы нам просто не добавлять юзера в сессию? или переделать

//                req.getRequestDispatcher("welcomePage.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return req.getContextPath() + "/page/home";
    }
}
