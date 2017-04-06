package com.pgs.ideaproject.entity;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;


    public User() {
    }


    public User(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


}
