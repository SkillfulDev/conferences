package com.chernonog.app.dao.sql;

public enum SQLTopic {
    SELECT_ALL_TOPICS_BY_EVENT_ID("select id, name from topic where event_id=?"),
    INSERT_TOPIC("insert into topic (name, event_id) values ((?), (?))"),
    UPDATE_TOPIC("update topic set name=? where id=?");

    public final String QUERY;

    SQLTopic(String QUERY) {
        this.QUERY = QUERY;
    }
}
