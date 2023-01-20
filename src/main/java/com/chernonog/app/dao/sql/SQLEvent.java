package com.chernonog.app.dao.sql;

public enum SQLEvent {
    SELECT_ALL_EVENTS("select * from event"),
    INSERT_EVENT("insert into event (name, descr, date, place) values ((?), (?),(?), (?))"),
    GET_EVENT_BY_ID("select * from event where id=?"),
    UPDATE_EVENT("update event set name=?, descr=?, date=?, place=? where id=?"),
    JOIN_USER_TO_EVENT("insert into event_has_user (event_id, user_id) values ((?), (?))"),
    SELECT_ALL_FUTURE_EVENTS("select * from event where date >= curdate()"),
    SELECT_ALL_PAST_EVENTS("select * from event where date <= curdate()");

    public final String QUERY;

    SQLEvent(String QUERY) {
        this.QUERY = QUERY;
    }
}
