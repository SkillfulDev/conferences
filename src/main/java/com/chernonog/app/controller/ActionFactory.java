package com.chernonog.app.controller;

import com.chernonog.app.controller.actions.ErrorPageAction;
import com.chernonog.app.controller.actions.HomePageAction;
import com.chernonog.app.controller.actions.LogoutAction;
import com.chernonog.app.controller.actions.event.moderator.*;
import com.chernonog.app.controller.actions.event.user.JoinUserToEventAction;
import com.chernonog.app.controller.actions.login.LoginGetAction;
import com.chernonog.app.controller.actions.login.LoginPostAction;
import com.chernonog.app.controller.actions.register.RegisterGetAction;
import com.chernonog.app.controller.actions.register.RegisterPostAction;
import com.chernonog.app.controller.actions.user.EditUserGetAction;
import com.chernonog.app.controller.actions.user.EditUserPostAction;
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
        actions.put(GET + ERROR, new ErrorPageAction());
        actions.put(GET + ADD_EVENT, new AddEventGetAction());
        actions.put(POST + ADD_EVENT, new AddEventPostAction());
        actions.put(GET + SHOW_ALL_EVENTS, new ShowAllEventsGetAction());
        actions.put(GET + EDIT_EVENT, new EditEventGetAction());
        actions.put(POST + EDIT_EVENT, new EditEventPostAction());
        actions.put(POST + JOIN_USER_TO_EVENT, new JoinUserToEventAction());
        actions.put(GET + EDIT_USER, new EditUserGetAction());
        actions.put(POST + EDIT_USER, new EditUserPostAction());
    }

    public static Action getAction(HttpServletRequest req) {
        return actions.get(req.getMethod() + req.getPathInfo());
    }
}
