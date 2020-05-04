package com.marwell.sdhelper.model;

import javax.persistence.*;

/**
 *
 * @author Eduardo Marwell
 */
@Entity
@Table(name="link")
public class Link {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="linkString")
    private String linkString;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkString() {
        return linkString;
    }

    public void setLinkString(String linkString) {
        this.linkString = linkString;
    }
}
