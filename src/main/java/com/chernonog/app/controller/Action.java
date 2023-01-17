package com.chernonog.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {

    String HOME = "home";
    String LOGIN = "login";
    String REGISTER = "register";
    String LOGOUT = "logout";
    String ERROR = "error";
    String ADD_EVENT = "event/add-event";
    String SHOW_ALL_EVENTS = "event/show-events";
    String EDIT_EVENT = "event/edit-event";

    String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
