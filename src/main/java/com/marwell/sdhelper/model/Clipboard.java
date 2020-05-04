package com.marwell.sdhelper.model;

import javax.persistence.*;

/**
 *
 * @author Eduardo Marwell
 */
@Entity
@Table(name="clipboard")
public class Clipboard {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="clipboardString")
    private String cliboardString;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliboardString() {
        return cliboardString;
    }

    public void setCliboardString(String cliboardString) {
        this.cliboardString = cliboardString;
    }

}
