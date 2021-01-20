package com.c0720i2.melody.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@IdClass(LikeSongId.class)
public class LikeSong {
    @Id
    @ManyToOne
    private Song song;
    @Id
    @ManyToOne
    private User user;
}
