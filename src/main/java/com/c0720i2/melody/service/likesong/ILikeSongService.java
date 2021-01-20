package com.c0720i2.melody.service.likesong;

import com.c0720i2.melody.model.LikeSong;
import com.c0720i2.melody.model.LikeSongId;
import com.c0720i2.melody.model.Song;
import com.c0720i2.melody.model.User;
import com.c0720i2.melody.service.IGeneralService;
import org.springframework.data.relational.core.sql.Like;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

public interface ILikeSongService {
    Iterable<LikeSong> findAll();
    Optional<LikeSong> findById(LikeSongId likeSongId);
    LikeSong save(LikeSong likeSong);
    void delete(LikeSongId likeSongId);
}
