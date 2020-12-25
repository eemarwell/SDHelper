package com.marwell.sdhelper.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

/**
 *
 * @author Eduardo Marwell
 */

@Entity
@Table(name="link")
@AllArgsConstructor
@ToString(exclude="id")
@Slf4j
public class Link {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    @Getter
    @NonNull
    private Long id;

    @Getter
    @Setter
    @Column(name="linkString")
    private String linkString;
}
