package com.chernonog.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    private int id;

    private String login;

    private String password;

    private String email;

    private Role role;

    private int permission;

    private List<Topic> topics = new ArrayList<>();

    private Topic topic;

    private String firstName;

    private String secondName;

}