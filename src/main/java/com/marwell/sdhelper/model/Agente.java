package com.marwell.sdhelper.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

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
@AllArgsConstructor
@ToString(exclude="id, accessLevel, backlog, chat")
@Slf4j
public class Agente {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    @Getter
    @NonNull
    private Long id;

    @Getter
    @Setter
    @Column(name="accessLevel")
    private int accessLevel;

    @Getter
    @Setter
    @Column(name="name")
    private String name;

    @Getter
    @Setter
    @Column(name="password")
    private String password;

    @Getter
    @Setter
    @Column(name="backlog")
    private boolean backlog;

    @Getter
    @Setter
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
}
