package com.chernonog.app.controller;

import com.chernonog.app.controller.actions.HomePageAction;
import com.chernonog.app.controller.actions.LoginGetAction;
import com.chernonog.app.controller.actions.LoginPostAction;
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
    }

    public static Action getAction(HttpServletRequest req) {
        return actions.get(req.getMethod() + req.getPathInfo());
    }
}
