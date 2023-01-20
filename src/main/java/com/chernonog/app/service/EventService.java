package com.chernonog.app.service;

import com.chernonog.app.dao.sql.SQLEvent;
import com.chernonog.app.model.Event;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface EventService {

    List<Event> getAllEvent(SQLEvent sortType);

    void addEvent(HttpServletRequest req);

    Event getEventByID(int eventID);

    void updateEvent(HttpServletRequest req);

    void joinUserToEvent(int userId, int eventId);
}
