package com.pgs.ideaproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;


@Entity
public class Comment {

    @Id
    private long id;
    private String text;
    private Date createdAt;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    public Comment() {
    }

    public Comment(long id, String text, Date createdAt, Post post, User user) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
        this.post = post;
        this.user = user;
    }
}
