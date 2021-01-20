package com.c0720i2.melody.service.likesong;

import com.c0720i2.melody.model.LikeSong;
import com.c0720i2.melody.model.LikeSongId;
import com.c0720i2.melody.model.Song;
import com.c0720i2.melody.model.User;
import com.c0720i2.melody.repository.LikeSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeSongService implements ILikeSongService {
    @Autowired
    private LikeSongRepository likeSongRepository;
    @Override
    public Iterable<LikeSong> findAll() {
        return likeSongRepository.findAll();
    }

    @Override
    public Optional<LikeSong> findById(LikeSongId likeSongId) {
        return likeSongRepository.findById(likeSongId);
    }

    @Override
    public LikeSong save(LikeSong likeSong) {
        return likeSongRepository.save(likeSong);
    }

    @Override
    public void delete(LikeSongId likeSongId) {
        likeSongRepository.deleteById(likeSongId);
    }


}
