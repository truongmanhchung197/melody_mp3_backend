package com.c0720i2.melody.model;

import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import javax.persistence.metamodel.SingularAttribute;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(nullable = false)
    private Long name;
    @Column(nullable = false)
    private String file;
    @Column(nullable = false)
    private Date creationTime;
    @Column(nullable = false)
    private Long numberOfView;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String avatar;
    @ManyToOne
    private Album album;
    @ManyToOne
    private Guest guest;
    @ManyToMany(mappedBy = "songs")
    private List<Singer> singers;
    @ManyToMany(mappedBy = "songs")
    private List<Playlist> playlists;

}
