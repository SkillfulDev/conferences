package com.chernonog.app.dao;

import com.chernonog.app.dao.sql.SQLEvent;
import com.chernonog.app.model.Event;

import java.util.List;

public interface EventDAO {
    List<Event> getAllEvent(SQLEvent sortType);

    void insertEvent(Event event);

    Event getEventByID(int eventID);

    void updateEvent(Event event);

    void joinUserToEvent(int userId, int eventId);
}
