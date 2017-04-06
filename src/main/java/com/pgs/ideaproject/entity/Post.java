package com.pgs.ideaproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;


@Entity
public class Post {

    @Id
    private long id;
    private String text;
    private Date createdAt;

    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(long id, String text, Date createdAt, User user) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
        this.user = user;
    }
}
