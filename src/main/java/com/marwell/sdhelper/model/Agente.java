package com.marwell.sdhelper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Eduardo Marwell
 */
@Entity
@Table(name="agente")
public class Agente {

    public Agente() {
    }

    public Agente(int accessLevel, String name, String password, boolean backlog, boolean chat) {
        this.accessLevel = accessLevel;
        this.name = name;
        this.password = password;
        this.backlog = backlog;
        this.chat = chat;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="accessLevel")
    private int accessLevel;

    @Column(name="name")
    private String name;
    
    @Column(name="password")
    private String password;
    
    @Column(name="backlog")
    private boolean backlog;
    
    @Column(name="chat")
    private boolean chat;

    public boolean isBacklog() {
        return backlog;
    }

    public void setBacklog(boolean backlog) {
        this.backlog = backlog;
    }

    public boolean isChat() {
        return chat;
    }

    public void setChat(boolean chat) {
        this.chat = chat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLvl) {
        this.accessLevel = accessLvl;
    }
}
