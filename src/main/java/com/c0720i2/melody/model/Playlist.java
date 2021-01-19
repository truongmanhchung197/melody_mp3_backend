package com.c0720i2.melody.model;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    private User user;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Song> songs;
}
