package com.c0720i2.melody.model;

import java.io.Serializable;

public class LikeSongId implements Serializable {
    private Song song;
    private User user;

    public LikeSongId(Song song, User user) {
        this.song = song;
        this.user = user;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
