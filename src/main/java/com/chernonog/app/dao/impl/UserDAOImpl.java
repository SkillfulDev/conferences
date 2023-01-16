package com.chernonog.app.dao.impl;

import com.chernonog.app.config.DataSource;
import com.chernonog.app.dao.UserDAO;
import com.chernonog.app.dao.sql.SQLUser;
import com.chernonog.app.model.Role;
import com.chernonog.app.model.User;
import lombok.SneakyThrows;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    @SneakyThrows
    @Override
    public User getUser(String login) {
        User user;

        try (PreparedStatement statement = DataSource.connection
                .prepareStatement(SQLUser.SELECT_BY_LOGIN.QUERY)) {
            statement.setString(1, login);

            ResultSet resultSet = statement.executeQuery();
            user = extractUser(resultSet);
        }

        return user;
    }

    @SneakyThrows
    @Override
    public User getUser(String login, String password) {
        User user;

        try (PreparedStatement statement = DataSource.connection
                .prepareStatement(SQLUser.SELECT_BY_LOGIN_AND_PASSWORD.QUERY)) {
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            user = extractUser(resultSet);
        }

        return user;
    }

    @Override
    public void insertUser(User user) {
        try (PreparedStatement statement = DataSource.connection.prepareStatement(SQLUser.INSERT.QUERY)) {
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getSecondName());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    private User extractUser(ResultSet resultSet) {
        User user = new User();

        if (resultSet.next()) {
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setRole(Role.valueOf(resultSet.getString("role")));
            user.setFirstName(resultSet.getString("first_name"));
            user.setSecondName(resultSet.getString("second_name"));
        } else {
            return null;
        }

        return user;
    }
}
