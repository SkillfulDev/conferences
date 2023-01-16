package com.chernonog.app.dao;

import com.chernonog.app.model.User;

public interface UserDAO {

    User getUser(String login);

    User getUser(String login, String password);

    void insertUser(User user);
}
