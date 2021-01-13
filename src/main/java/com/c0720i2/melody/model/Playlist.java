package com.c0720i2.melody.model;

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
    @ManyToOne
    private Guest guest;
    @ManyToMany
    @JoinTable
    private List<Song> songs;

}
