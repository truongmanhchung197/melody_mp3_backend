package com.c0720i2.melody.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class CommentSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 1000)
    private String content;
    @Column(nullable = false)
    private Date creationTime;
    @ManyToOne
    private Song song;
    @ManyToOne
    private User user;
}
