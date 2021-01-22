package com.c0720i2.melody.service.likeplaylist;

import com.c0720i2.melody.model.LikePlaylist;
import com.c0720i2.melody.model.LikePlaylistId;

import java.util.Optional;

public interface ILikePlaylistService {
    Iterable<LikePlaylist> findAll();
    Optional<LikePlaylist> findById(LikePlaylistId likePlaylistId);
    LikePlaylist save(LikePlaylist likePlaylist);
    void delete(LikePlaylistId likePlaylistId);
}
