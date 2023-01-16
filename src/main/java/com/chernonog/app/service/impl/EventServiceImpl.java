package com.chernonog.app.service.impl;

import com.chernonog.app.dao.DAOFactory;
import com.chernonog.app.dao.EventDAO;
import com.chernonog.app.model.Event;
import com.chernonog.app.service.EventService;

import java.util.List;

public class EventServiceImpl implements EventService {

    private final EventDAO eventDAO = DAOFactory.getEventDAO();

    @Override
    public List<Event> getAllEvent() {
        return eventDAO.getAllEvent();
    }
}
