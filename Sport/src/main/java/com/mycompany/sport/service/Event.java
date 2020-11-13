/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sport.service;

import com.mycompany.sport.auth.User;
import static com.mycompany.sport.service.Event.FIND_ALL_EVENTS;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//if util.date doesnt work try sql.Date instead? @TODO remove this if it works.
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author sigurd
 */
@Table(name = "Event")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NamedQuery(name = FIND_ALL_EVENTS,
        query = "select e from Event e")

public class Event implements Serializable {
    public static final String FIND_ALL_EVENTS = "Event.findAllEvents";
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO) @EqualsAndHashCode.Include
    private Long eventid;
    
    private String sport;
    private String description;
    private Date date;
    private String location;
    private Time time;
    private int maxPlayers;
    
    
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private User eventCreator;
    
    
    @ManyToMany
    @JoinTable(name="USEREVENT",
            joinColumns = @JoinColumn(name="eventid", referencedColumnName = "eventid"),
            inverseJoinColumns = @JoinColumn(name="userid", referencedColumnName = "userid"))
    private List<User> eventAttenders;
    
    
    public void addAttender(User user){
        if(eventAttenders == null){
            eventAttenders = new ArrayList<User>();
        }
        if(eventAttenders.size()<= maxPlayers){
        eventAttenders.add(user);
        }
    }
    public void removeAttender(User user){
        if(user != null) {
            eventAttenders.remove(user);
        }
    }
}
