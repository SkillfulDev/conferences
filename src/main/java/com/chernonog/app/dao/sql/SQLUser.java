package com.chernonog.app.dao.sql;

public enum SQLUser {
    SELECT_BY_LOGIN("select * from user where login=?"),
    SELECT_BY_LOGIN_AND_PASSWORD("select * from user where login=? and password=?"),
    INSERT("insert into user (login, password, email, first_name, second_name)" +
            " values ((?), (?), (?), (?), (?))"),
    UPDATE_USER("update user set login=?, email=?, role=?, first_name=?, second_name=? where id=?");

    public final String QUERY;

    SQLUser(String QUERY) {
        this.QUERY = QUERY;
    }
}
