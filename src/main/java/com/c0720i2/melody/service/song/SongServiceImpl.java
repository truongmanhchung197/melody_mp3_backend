package com.c0720i2.melody.service.song;

import com.c0720i2.melody.model.Playlist;
import com.c0720i2.melody.model.Song;
import com.c0720i2.melody.repository.LikeSongRepository;
import com.c0720i2.melody.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private LikeSongRepository likeSongRepository;
    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Iterable<Song> listLatest() {
        return songRepository.findAllByCreationTimeOrderByCreationTime();
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








    @Override
    public Iterable<Song> listSongsByUser(Long id) {
        return songRepository.findAllByUserId(id);
    }

    @Override
    public Iterable<Song> findByName(String keyword) {
        return songRepository.findAllByNameContains(keyword);
    }
    @Override
    public Iterable<Song> getList10SongInTopView() {
        return songRepository.findAllByNumberOfViewOrderByNumberOfView();
    }

    @Override
    public Iterable<Song> findAllByUserId(Long idUser) {
        return songRepository.findAllByUserId(idUser);
    }

    @Override
    public Iterable<Song> topLikeSong() {
        Iterable<BigInteger> likeSong = likeSongRepository.findAllByUserLike();
        List<Long> array = new ArrayList<>();
        List<Song> songs = new ArrayList<>();

        for (BigInteger like : likeSong){
            Long longNumber= like.longValue();
            array.add(longNumber);
        }
        for (Long e: array){
            songs.add(songRepository.findById(e).get());
        }
        return songs;
    }


}

