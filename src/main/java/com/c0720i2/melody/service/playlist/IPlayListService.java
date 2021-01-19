package com.c0720i2.melody.service.playlist;

import com.c0720i2.melody.model.Playlist;
import com.c0720i2.melody.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IPlayListService {
    Iterable<Playlist> getAll();
    Playlist save (Playlist playlist);
    Optional<Playlist> findById(Long id);
    void remove(Long id);
    Iterable<Playlist> findAllByUserUsername(String username);
    Playlist addSongToPlaylist(Long idSong, Long idPlaylist);
    Iterable<Playlist> listLatest();
    Iterable<Playlist> topView();
}
