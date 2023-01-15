package com.chernonog.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {

    String HOME = "home";
    String LOGIN = "login";

    String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;
}