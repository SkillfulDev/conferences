package com.chernonog.app.controller.actions.event;

import com.chernonog.app.controller.Action;
import com.chernonog.app.model.Event;
import com.chernonog.app.model.Role;
import com.chernonog.app.model.User;
import com.chernonog.app.service.EventService;
import com.chernonog.app.service.impl.EventServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

//FIXME ПЕРЕДЕЛАТЬ К ХУЯМ ЧЕРЕЗ ФИЛЬТРЫ
public class ShowAllEventsGetAction implements Action {

    private EventService eventService = new EventServiceImpl();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = (User) req.getSession().getAttribute("user");
        Role role = user.getRole();

        if (role.equals(Role.MODERATOR)) {
            List<Event> events = eventService.getAllEvent();
            req.setAttribute("events", events);
        } else {
            return req.getContextPath() + "/pages/error";
        }

        return SHOW_ALL_EVENTS;
    }
}
