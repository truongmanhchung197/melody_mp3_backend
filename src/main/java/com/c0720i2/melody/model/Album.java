package com.c0720i2.melody.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date creationTime;
    @Column(nullable = false)
    private Long numberOfView;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Singer> singers;
    @ManyToOne
    private User user;
}
