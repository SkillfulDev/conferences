package com.chernonog.app.dao.impl;

import com.chernonog.app.config.DataSource;
import com.chernonog.app.dao.TopicDAO;
import com.chernonog.app.dao.sql.SQLTopic;
import com.chernonog.app.model.Topic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicDAOImpl implements TopicDAO {
    @Override
    public List<Topic> getAllEventTopics(int eventId) {
        List<Topic> topics = new ArrayList<>();

        try (PreparedStatement preparedStatement = DataSource.connection
                .prepareStatement(SQLTopic.SELECT_ALL_TOPICS_BY_EVENT_ID.QUERY)) {
            preparedStatement.setInt(1, eventId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Topic topic = new Topic(resultSet.getInt("id"),
                        resultSet.getString("name"));
                topics.add(topic);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topics;
    }

    @Override
    public void insertTopics(List<Topic> topics, int eventId) {
        for (Topic topic : topics) {
            try (PreparedStatement preparedStatement = DataSource.connection
                    .prepareStatement(SQLTopic.INSERT_TOPIC.QUERY)) {
                preparedStatement.setString(1, topic.getName());
                preparedStatement.setInt(2, eventId);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
