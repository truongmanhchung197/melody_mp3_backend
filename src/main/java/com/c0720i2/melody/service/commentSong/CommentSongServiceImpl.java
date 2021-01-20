package com.c0720i2.melody.service.commentSong;

import com.c0720i2.melody.model.CommentSong;
import com.c0720i2.melody.repository.CommentSongRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CommentSongServiceImpl implements CommentSongService {

    @Autowired
    CommentSongRepository commentSongRepository;

    @Override
    public Optional<CommentSong> findById(Long id) {
        return commentSongRepository.findById(id);
    }

    @Override
    public Iterable<CommentSong> findAll() {
        return commentSongRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        commentSongRepository.deleteById(id);
    }

    @Override
    public CommentSong save(CommentSong commentSong) {
        return commentSongRepository.save(commentSong);
    }
}
