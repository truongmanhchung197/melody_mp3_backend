package com.c0720i2.melody.service.commentPlaylist;

import com.c0720i2.melody.model.CommentPlaylist;
import com.c0720i2.melody.model.Playlist;
import com.c0720i2.melody.repository.CommentPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CommentPlaylistService implements ICommentPlaylistService {

    @Autowired
    private CommentPlaylistRepository commentPlaylistRepository;

    @Override
    public Iterable<CommentPlaylist> getCommentPlaylistsByPlaylist(Playlist playlist) {
        return commentPlaylistRepository.getCommentPlaylistsByPlaylist(playlist);
    }

    @Override
    public Optional<CommentPlaylist> findById(Long id) {
        return commentPlaylistRepository.findById(id);
    }

    @Override
    public Iterable<CommentPlaylist> findAll() {
        return commentPlaylistRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        commentPlaylistRepository.deleteById(id);
    }

    @Override
    public CommentPlaylist save(CommentPlaylist commentPlaylist) {
        return commentPlaylistRepository.save(commentPlaylist);
    }
}
