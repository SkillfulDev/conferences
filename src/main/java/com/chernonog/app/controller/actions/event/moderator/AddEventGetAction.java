package com.chernonog.app.controller.actions.event.moderator;

import com.chernonog.app.controller.Action;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddEventGetAction implements Action {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return ADD_EVENT;
    }
}
