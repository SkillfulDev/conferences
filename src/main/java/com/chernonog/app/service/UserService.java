package com.chernonog.app.service;

import com.chernonog.app.model.User;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    User getUserByLogin(String login);

    User getUserByLoginAndPassword(String login, String password);

    void saveUser(HttpServletRequest req);

    void  updateUser (HttpServletRequest req);
}
