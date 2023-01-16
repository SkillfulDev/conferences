package com.chernonog.app.dao.sql;

public enum SQLEvent {
    SELECT_ALL_EVENTS("select * from event");

    public final String QUERY;

    SQLEvent(String QUERY) {
        this.QUERY = QUERY;
    }
}
