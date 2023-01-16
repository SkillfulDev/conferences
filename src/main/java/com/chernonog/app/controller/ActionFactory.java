package com.chernonog.app.controller;

import com.chernonog.app.controller.actions.HomePageAction;
import com.chernonog.app.controller.actions.LogoutAction;
import com.chernonog.app.controller.actions.login.LoginGetAction;
import com.chernonog.app.controller.actions.login.LoginPostAction;
import com.chernonog.app.controller.actions.register.RegisterGetAction;
import com.chernonog.app.controller.actions.register.RegisterPostAction;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static com.chernonog.app.controller.Action.*;

public class ActionFactory {

    public static final String GET = "GET/";
    public static final String POST = "POST/";

    private static final Map<String, Action> actions = new HashMap<>();

    static {
        actions.put(GET + HOME, new HomePageAction());
        actions.put(GET + LOGIN, new LoginGetAction());
        actions.put(POST + LOGIN, new LoginPostAction());
        actions.put(GET + REGISTER, new RegisterGetAction());
        actions.put(POST + REGISTER, new RegisterPostAction());
        actions.put(POST + LOGOUT, new LogoutAction());
    }

    public static Action getAction(HttpServletRequest req) {
        return actions.get(req.getMethod() + req.getPathInfo());
    }
}
