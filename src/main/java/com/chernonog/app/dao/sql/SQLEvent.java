package com.chernonog.app.dao.sql;

public enum SQLEvent {
    SELECT_ALL_EVENTS("select * from event"),
    INSERT_EVENT("insert into event (name, descr, date, place) values ((?), (?),(?), (?))"),
    GET_EVENT_BY_ID("select * from event where id=?"),
    UPDATE_EVENT("update event set name=?, descr=?, date=?, place=? where id=?");

    public final String QUERY;

    SQLEvent(String QUERY) {
        this.QUERY = QUERY;
    }
}
