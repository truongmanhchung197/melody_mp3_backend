package com.c0720i2.melody.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CommentSinger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 1000)
    private String content;
    @ManyToOne
    private UserDetail userDetail;
    @ManyToOne
    private User user;
}
