package com.chernonog.app.service.impl;

import com.chernonog.app.dao.DAOFactory;
import com.chernonog.app.dao.UserDAO;
import com.chernonog.app.model.User;
import com.chernonog.app.service.UserService;
import jakarta.servlet.http.HttpServletRequest;

public class UserServiceImpl implements UserService {

    private final UserDAO userDAO = DAOFactory.getUserDAO();

    @Override
    public User getUserByLogin(String login) {
        return userDAO.getUser(login);
    }

    @Override
    public User getUserByLoginAndPassword(String login, String password) {
        return userDAO.getUser(login, password);
    }

    @Override
    public void saveUser(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String first_name = req.getParameter("first_name");
        String second_name = req.getParameter("second_name");

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(first_name);
        user.setSecondName(second_name);

        userDAO.insertUser(user);
    }

    @Override
    public void updateUser(HttpServletRequest req) {
        String login = req.getParameter("login");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String first_name= req.getParameter("first_name");
        String second_name = req.getParameter("second_name");



        User user = (User) req.getSession().getAttribute("user");
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(first_name);
        user.setSecondName(second_name);

        userDAO.updateUser(user);
    }


}
