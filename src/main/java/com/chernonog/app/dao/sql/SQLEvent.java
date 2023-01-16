package com.chernonog.app.dao.sql;

public enum SQLEvent {
    SELECT_ALL_EVENTS("select * from event"),
    INSERT_EVENT("insert into event (name, descr, date, place) values ((?), (?),(?), (?))");

    public final String QUERY;

    SQLEvent(String QUERY) {
        this.QUERY = QUERY;
    }
}
