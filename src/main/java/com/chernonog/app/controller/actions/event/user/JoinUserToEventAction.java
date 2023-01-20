package com.chernonog.app.controller.actions.event.user;

import com.chernonog.app.controller.Action;
import com.chernonog.app.model.User;
import com.chernonog.app.service.EventService;
import com.chernonog.app.service.impl.EventServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JoinUserToEventAction implements Action {

    private EventService eventService = new EventServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = (User) req.getSession().getAttribute("user");
        int eventId = Integer.parseInt(req.getParameter("eventId"));
        int userId = user.getId();

        eventService.joinUserToEvent(userId, eventId);

        return req.getContextPath() + "/pages/home";
    }
}
