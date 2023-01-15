package com.chernonog.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Event {
    private int id;

    private String name;

    private String describe;

    private String date;

    private String place;

    private List<Topic> topics;
}