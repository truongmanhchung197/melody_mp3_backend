package com.c0720i2.melody.service.playlist;

import com.c0720i2.melody.model.Playlist;
import com.c0720i2.melody.model.Song;
import com.c0720i2.melody.repository.LikePlaylistRepository;
import com.c0720i2.melody.repository.PlayListRepository;
import com.c0720i2.melody.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayListService implements IPlayListService {
    @Autowired
    private PlayListRepository playListRepository;
    @Autowired
    private LikePlaylistRepository likePlaylistRepository;
    @Autowired
    private SongRepository songRepository;

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

    @Override
    public Iterable<Playlist> findAllByUserUsername(String username) {
        return playListRepository.findAllByUserUsername(username);
    }

    @Override
    public Playlist addSongToPlaylist(Long idSong, Long idPlaylist) {
        Song song = songRepository.findById(idSong).get();
        Playlist playlist = playListRepository.findById(idPlaylist).get();
        List<Song> songs = playlist.getSongs();
        if (songs.contains(song)){
            return null;
        }
        songs.add(song);
        playlist.setSongs(songs);
        playListRepository.save(playlist);
        return playlist;
    }

    @Override
    public Iterable<Playlist> listLatest() {
        return playListRepository.findAllByCreationTimeOrderByCreationTime();
    }

    @Override
    public Iterable<Playlist> topView() {
        return playListRepository.findAllByViewOrderByView();
    }

}
