package com.chernonog.app.service.impl;

import com.chernonog.app.dao.DAOFactory;
import com.chernonog.app.dao.EventDAO;
import com.chernonog.app.model.Event;
import com.chernonog.app.model.Topic;
import com.chernonog.app.service.EventService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public class EventServiceImpl implements EventService {
    @Override
    public Event getEventByID(int eventID) {
        return null;
    }

    private final EventDAO eventDAO = DAOFactory.getEventDAO();

    @Override
    public List<Event> getAllEvent() {
        return eventDAO.getAllEvent();
    }

    @Override
    public void addEvent(HttpServletRequest req) {
        String eventName = req.getParameter("name");
        String eventDescribe = req.getParameter("descr");
        String eventPlace = req.getParameter("place");
        String[] topicsName = req.getParameterValues("topic");

        Event event = new Event();
        event.setName(eventName);
        event.setDescribe(eventDescribe);
        event.setDate(req.getParameter("date"));
        event.setPlace(eventPlace);

        List<Topic> topics = new ArrayList<>();

        for (String topicName : topicsName) {
            Topic topic = new Topic(topicName);
            topics.add(topic);
        }

        event.setTopics(topics);

        eventDAO.insertEvent(event);
    }

}
