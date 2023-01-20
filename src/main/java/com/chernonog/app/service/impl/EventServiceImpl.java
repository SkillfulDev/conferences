package com.chernonog.app.service.impl;

import com.chernonog.app.dao.DAOFactory;
import com.chernonog.app.dao.EventDAO;
import com.chernonog.app.dao.sql.SQLEvent;
import com.chernonog.app.model.Event;
import com.chernonog.app.model.Topic;
import com.chernonog.app.service.EventService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public class EventServiceImpl implements EventService {

    private final EventDAO eventDAO = DAOFactory.getEventDAO();

    @Override
    public List<Event> getAllEvent(SQLEvent sortType) {
        return eventDAO.getAllEvent(sortType);
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

    @Override
    public Event getEventByID(int eventID) {
        return eventDAO.getEventByID(eventID);
    }

    @Override
    public void updateEvent(HttpServletRequest req) {
        String[] topics = req.getParameterValues("topic");

        Event event = getEventByID(Integer.parseInt(req.getParameter("eventID")));
        event.setName(req.getParameter("name"));
        event.setDescribe(req.getParameter("describe"));
        event.setDate(req.getParameter("date"));
        event.setPlace(req.getParameter("place"));

        List<Topic> topicList = event.getTopics();

        for (int i = 0; i < topics.length; i++) {
            if (i < topicList.size()) {
                Topic topic = topicList.get(i);
                topic.setName(topics[i]);
                topicList.set(i, topic);
            } else {
                Topic topic = new Topic();
                topic.setName(topics[i]);
                topicList.add(topic);
                DAOFactory.getTopicDAO().insertTopic(topic, event.getId());
            }
        }

        event.setTopics(topicList);

        eventDAO.updateEvent(event);
    }

    @Override
    public void joinUserToEvent(int userId, int eventId) {
        eventDAO.joinUserToEvent(userId, eventId);
    }

}
