package com.chernonog.app.controller.actions.event.moderator;

import com.chernonog.app.controller.Action;
import com.chernonog.app.dao.sql.SQLEvent;
import com.chernonog.app.model.Event;
import com.chernonog.app.service.EventService;
import com.chernonog.app.service.impl.EventServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class ShowAllEventsGetAction implements Action {

    private EventService eventService = new EventServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Event> events = eventService.getAllEvent(SQLEvent.SELECT_ALL_EVENTS);
        System.out.println(req.getParameter("bomj"));
        req.setAttribute("events", events);

        return SHOW_ALL_EVENTS;
    }
}
