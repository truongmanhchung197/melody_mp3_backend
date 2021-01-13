package com.c0720i2.melody.service;

import com.c0720i2.melody.model.Song;

public interface SongService {
    Iterable<Song> findAll();
    Song findById(Long id);
    Song save(Song song);
    void delete(Long id);
}
