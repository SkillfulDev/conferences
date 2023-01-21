package com.chernonog.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {

    String HOME = "home";
    String LOGIN = "login";
    String REGISTER = "register";
    String LOGOUT = "logout";
    String ERROR = "error";
    String ADD_EVENT = "admin/add-event";
    String SHOW_ALL_EVENTS = "admin/show-events";
    String EDIT_EVENT = "admin/edit-event";
    String JOIN_USER_TO_EVENT = "join";
    String EDIT_USER = "settings";
    String DELETE_EVENT = "admin/delete";


    String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
