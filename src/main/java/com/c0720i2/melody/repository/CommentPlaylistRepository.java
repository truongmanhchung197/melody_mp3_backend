package com.c0720i2.melody.repository;

import com.c0720i2.melody.model.CommentPlaylist;
import com.c0720i2.melody.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentPlaylistRepository extends JpaRepository<CommentPlaylist, Long> {
    Iterable<CommentPlaylist> getCommentPlaylistsByPlaylist(Playlist playlist);

}
