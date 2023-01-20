package com.chernonog.app.controller.actions.event.moderator;

import com.chernonog.app.controller.Action;
import com.chernonog.app.service.EventService;
import com.chernonog.app.service.impl.EventServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditEventPostAction implements Action {

    private EventService eventService = new EventServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        eventService.updateEvent(req);

        return req.getContextPath() + "/pages/admin/show-events";
    }
}
