package com.c0720i2.melody.service.commentSong;

import com.c0720i2.melody.model.CommentSong;
import com.c0720i2.melody.model.Song;
import com.c0720i2.melody.service.IGeneralService;
import org.springframework.stereotype.Service;

@Service
public interface CommentSongService extends IGeneralService<CommentSong> {
    Iterable<CommentSong> getCommentSongsBySongOrderByCreationTimeDesc(Song song);
//    Iterable<CommentSong> findAllByCreationTimeOrderByCreationTime();
}
