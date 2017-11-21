package io.carlosarosemena.lookify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class song {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @Size(min=5, message = "There is a minimum of 5 characters required")
    private String title;

    @Column
    @Size(min=5, message = "There is a minimum of 5 characters required")

    private String artist;

    @Column

    private int rating;
}
