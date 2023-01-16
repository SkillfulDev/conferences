package com.chernonog.app.dao;

import com.chernonog.app.model.Topic;

import java.util.List;

public interface TopicDAO {

    List<Topic> getAllEventTopics(int eventId);
}
