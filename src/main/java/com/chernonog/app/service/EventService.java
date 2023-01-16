package com.chernonog.app.service;

import com.chernonog.app.model.Event;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public interface EventService {

    List<Event> getAllEvent();

    void addEvent(HttpServletRequest req);
}
