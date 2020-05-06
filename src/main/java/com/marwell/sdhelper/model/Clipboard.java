package com.marwell.sdhelper.model;

import javax.persistence.*;
import javax.sound.sampled.Clip;

/**
 *
 * @author Eduardo Marwell
 */
@Entity
@Table(name="clipboard")
public class Clipboard {

    public Clipboard (){

    }

    public Clipboard (String clipboardString){
        this.clipboardString = clipboardString;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="clipboardString")
    private String clipboardString;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClipboardString() {
        return clipboardString;
    }

    public void getClipboardString(String clipboardString) {
        this.clipboardString = clipboardString;
    }

}
