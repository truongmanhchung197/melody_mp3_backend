package com.c0720i2.melody.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LikePlaylist {
    @EmbeddedId
    private LikePlaylistId likePlaylistId;

    public LikePlaylist(LikePlaylistId likePlaylistId) {
        this.likePlaylistId = likePlaylistId;
    }

    public LikePlaylist() {
    }
}
