package com.chernonog.app.dao;

import com.chernonog.app.model.Event;

import java.util.List;

public interface EventDAO {
    List<Event> getAllEvent();

    void insertEvent(Event event);

    Event getEventByID(int eventID);
}
