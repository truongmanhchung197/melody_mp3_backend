package com.c0720i2.melody.service.song;

import com.c0720i2.melody.model.Song;
import com.c0720i2.melody.model.User;

public interface SongService {
    Iterable<Song> findAll();
    Iterable<Song> listLatest();
    Iterable<Song> listSongsByUser(Long id);
    Iterable<Song> findByName(String keyword);
    Song findById(Long id);
    Song save(Song song);
    void delete(Long id);
}
