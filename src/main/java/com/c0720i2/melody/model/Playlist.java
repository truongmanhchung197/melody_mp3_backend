package com.c0720i2.melody.model;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date creationTime;
    private String avatar;
    @ManyToOne
    private User user;
    @ManyToMany
    @JoinTable
    private List<Song> songs;
}
