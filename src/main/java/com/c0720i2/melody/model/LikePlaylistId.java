package com.c0720i2.melody.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class LikePlaylistId implements Serializable {
    @ManyToOne
    private Playlist playlist;
    @ManyToOne
    private User user;

    public LikePlaylistId(Playlist playlist, User user) {
        this.playlist = playlist;
        this.user = user;
    }

    public LikePlaylistId() {
    }
}
