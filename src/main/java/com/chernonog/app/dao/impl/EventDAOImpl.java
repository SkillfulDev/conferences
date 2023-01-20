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
    public List<Event> getAllEvent(SQLEvent sortType) {
        List<Event> listEvent = new ArrayList<>();
        try (Statement statement = DataSource.connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sortType.QUERY)) {
            while (resultSet.next()) {
                Event event = extractEvent(resultSet);
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

    @Override
    public Event getEventByID(int eventID) {
        Event event = new Event();

        try (PreparedStatement preparedStatement = DataSource.connection
                .prepareStatement(SQLEvent.GET_EVENT_BY_ID.QUERY)) {
            preparedStatement.setInt(1, eventID);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                event = extractEvent(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return event;
    }

    @Override
    public void updateEvent(Event event) {
        try (PreparedStatement statement = DataSource.connection.prepareStatement(SQLEvent.UPDATE_EVENT.QUERY)) {
            statement.setString(1, event.getName());
            statement.setString(2, event.getDescribe());
            statement.setString(3, event.getDate());
            statement.setString(4, event.getPlace());
            statement.setInt(5, event.getId());
            DAOFactory.getTopicDAO().updateTopics(event.getTopics());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void joinUserToEvent(int userId, int eventId) {
        try (PreparedStatement statement = DataSource.connection
                .prepareStatement(SQLEvent.JOIN_USER_TO_EVENT.QUERY)) {
            statement.setInt(1, eventId);
            statement.setInt(2, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Event extractEvent(ResultSet resultSet) throws SQLException {
        Event event = new Event();
        event.setId(resultSet.getInt("id"));
        event.setPlace(resultSet.getString("place"));
        event.setName(resultSet.getString("name"));
        event.setDescribe(resultSet.getString("descr"));

        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                .format(resultSet.getTimestamp("date"));
        event.setDate(date);
        event.setTopics(DAOFactory.getTopicDAO().getAllEventTopics(resultSet.getInt("id")));
        return event;
    }
}
