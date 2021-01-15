package com.c0720i2.melody.service.song;

import com.c0720i2.melody.model.Song;

public interface SongService {
    Iterable<Song> findAll();
    Iterable<Song> listLatest();
    Song findById(Long id);
    Song save(Song song);
    void delete(Long id);
    Iterable<Song> getList10SongInTopView();
}
