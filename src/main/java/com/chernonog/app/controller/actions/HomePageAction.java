package com.chernonog.app.controller.actions;

import com.chernonog.app.controller.Action;
import com.chernonog.app.dao.sql.SQLEvent;
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
        SQLEvent sort = SQLEvent.SELECT_ALL_EVENTS;

        if (req.getParameter("sort") != null) {
            switch (req.getParameter("sort")) {
                case "future":
                    sort = SQLEvent.SELECT_ALL_FUTURE_EVENTS;
                    break;
                case "past":
                    sort = SQLEvent.SELECT_ALL_PAST_EVENTS;
                    break;
            }
        }

        System.out.println(req.getParameter("sort"));
        List<Event> events = eventService.getAllEvent(sort);
        req.setAttribute("events", events);

        return HOME;
    }
}
