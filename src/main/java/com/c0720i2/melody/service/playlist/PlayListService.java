package com.c0720i2.melody.service.playlist;

import com.c0720i2.melody.model.Playlist;
import com.c0720i2.melody.repository.PlayListRepository;
import com.c0720i2.melody.service.playlist.IPlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PlayListService implements IPlayListService {
    @Autowired
    private PlayListRepository playListRepository;

    @Override
    public Iterable<Playlist> getAll() {
        return playListRepository.findAll();
    }

    @Override
    public Playlist save(Playlist playlist) {
        return playListRepository.save(playlist);
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return playListRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        playListRepository.deleteById(id);
    }
}
