package com.los.travelcenter.user;

import com.los.travelcenter.journey.Journey;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jagod on 15.05.2017.
 */

@Entity
@Data
public class User {

    @Id @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private List<Journey> journeys = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }
}
