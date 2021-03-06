package com.c0720i2.melody.service;

import com.c0720i2.melody.model.Song;
import com.c0720i2.melody.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService{
    @Autowired
    private SongRepository songRepository;
    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public Song save(Song song) {
        return songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
        songRepository.deleteById(id);
    }
}
