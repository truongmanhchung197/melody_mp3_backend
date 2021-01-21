package com.c0720i2.melody.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class LikeSongId implements Serializable {
    @ManyToOne
    private Song song;
    @ManyToOne
    private User user;

    public LikeSongId(Song song, User user) {
        this.song = song;
        this.user = user;
    }

    public LikeSongId() {
    }
}
