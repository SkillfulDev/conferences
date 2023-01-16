package com.chernonog.app.controller.actions;

import com.chernonog.app.controller.Action;
import com.chernonog.app.model.Event;
import com.chernonog.app.service.EventService;
import com.chernonog.app.service.impl.EventServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class HomePageAction implements Action {

    private EventService eventService = new EventServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Event> events = eventService.getAllEvent();

        req.setAttribute("events", events);
        return HOME;
    }
}
