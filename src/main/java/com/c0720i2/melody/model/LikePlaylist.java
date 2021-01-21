package com.c0720i2.melody.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@IdClass(LikePlaylistId.class)
public class LikePlaylist {
    @Id
    @ManyToOne
    private Playlist playlist;
    @Id
    @ManyToOne
    private User user;
}
