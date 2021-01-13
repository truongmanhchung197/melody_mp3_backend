package com.c0720i2.melody.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @ManyToMany
    @JoinTable
    private List<Song> songs;
}
