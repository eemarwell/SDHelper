package com.marwell.sdhelper.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 *
 * @author Eduardo Marwell
 */

@Entity
@Table(name="clipboard")
@AllArgsConstructor
@ToString(exclude="id")
@Slf4j
public class Clipboard {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    @Getter
    @NonNull
    private Long id;

    @Getter
    @Setter
    @Column(name="clipboardString")
    private String clipboardString;

}
