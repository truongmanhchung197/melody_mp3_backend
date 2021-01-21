package com.c0720i2.melody.model;

import java.io.Serializable;

public class LikePlaylistId implements Serializable {
    private Playlist playlist;
    private User user;

    public LikePlaylistId(Playlist playlist, User user) {
        this.playlist = playlist;
        this.user = user;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
