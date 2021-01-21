package com.c0720i2.melody.service.commentPlaylist;

import com.c0720i2.melody.model.CommentPlaylist;
import com.c0720i2.melody.model.Playlist;
import com.c0720i2.melody.service.IGeneralService;
import org.springframework.stereotype.Service;

@Service
public interface ICommentPlaylistService extends IGeneralService<CommentPlaylist> {
    Iterable<CommentPlaylist> getCommentPlaylistsByPlaylist(Playlist playlist);
}
