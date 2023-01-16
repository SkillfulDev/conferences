package com.chernonog.app.dao;

import com.chernonog.app.dao.impl.EventDAOImpl;
import com.chernonog.app.dao.impl.TopicDAOImpl;
import com.chernonog.app.dao.impl.UserDAOImpl;

public class DAOFactory {

    public static UserDAO getUserDAO() {
        return new UserDAOImpl();
    }

    public static EventDAO getEventDAO() {
        return new EventDAOImpl();
    }

    public static TopicDAO getTopicDAO() {
        return new TopicDAOImpl();
    }
}
