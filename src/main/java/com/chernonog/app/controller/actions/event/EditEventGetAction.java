package com.chernonog.app.controller.actions.event;

import com.chernonog.app.controller.Action;
import com.chernonog.app.model.Event;
import com.chernonog.app.service.EventService;
import com.chernonog.app.service.impl.EventServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditEventGetAction implements Action {
    private EventService eventService = new EventServiceImpl();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Integer eventID = Integer.valueOf(req.getParameter("eventID"));

        Event event = eventService.getEventByID(eventID);

        req.setAttribute("event", event);
        return EDIT_EVENT;
    }
}
