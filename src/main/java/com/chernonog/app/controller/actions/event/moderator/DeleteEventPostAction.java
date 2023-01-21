package com.chernonog.app.controller.actions.event.moderator;

import com.chernonog.app.controller.Action;
import com.chernonog.app.model.Event;
import com.chernonog.app.service.EventService;
import com.chernonog.app.service.impl.EventServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteEventPostAction implements Action {
    EventService eventService = new EventServiceImpl();
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int eventID = Integer.parseInt(req.getParameter("eventID"));
        eventService.deleteEvent(eventID);
        Event event = eventService.getEventByID(eventID);

        req.setAttribute("event", event);
        return DELETE_EVENT;
    }
}
