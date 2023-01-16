package com.chernonog.app.dao.impl;

import com.chernonog.app.config.DataSource;
import com.chernonog.app.dao.DAOFactory;
import com.chernonog.app.dao.EventDAO;
import com.chernonog.app.dao.sql.SQLEvent;
import com.chernonog.app.model.Event;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EventDAOImpl implements EventDAO {
    @Override
    public List<Event> getAllEvent() {
        List<Event> listEvent = new ArrayList<>();
        try (Statement statement = DataSource.connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQLEvent.SELECT_ALL_EVENTS.QUERY)) {
            while (resultSet.next()) {
                Event event = new Event();
                event.setId(resultSet.getInt("id"));
                event.setPlace(resultSet.getString("place"));
                event.setName(resultSet.getString("name"));
                event.setDescribe(resultSet.getString("descr"));

                String date = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                        .format(resultSet.getTimestamp("date"));
                event.setDate(date);
                event.setTopics(DAOFactory.getTopicDAO().getAllEventTopics(resultSet.getInt("id")));
                listEvent.add(event);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listEvent;
    }

    @Override
    public void insertEvent(Event event) {
        try (PreparedStatement preparedStatement = DataSource.connection
                .prepareStatement(SQLEvent.INSERT_EVENT.QUERY, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, event.getName());
            preparedStatement.setString(2, event.getDescribe());
            preparedStatement.setString(3, event.getDate());
            preparedStatement.setString(4, event.getPlace());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                DAOFactory.getTopicDAO().insertTopics(event.getTopics(), resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
