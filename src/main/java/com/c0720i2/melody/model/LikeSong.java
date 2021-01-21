package com.c0720i2.melody.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LikeSong {
    @EmbeddedId
    private LikeSongId likeSongId;

    public LikeSong(LikeSongId likeSongId) {
        this.likeSongId = likeSongId;
    }

    public LikeSong() {
    }
}
