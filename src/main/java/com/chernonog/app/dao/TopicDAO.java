package com.chernonog.app.dao;

import com.chernonog.app.model.Topic;

import java.util.List;

public interface TopicDAO {

    List<Topic> getAllEventTopics(int eventId);

    void insertTopics(List<Topic> topics, int eventId);

    void updateTopics(List<Topic> topics);

    void insertTopic(Topic topic, int eventId);
}
