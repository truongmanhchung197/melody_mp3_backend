package com.c0720i2.melody.service.singer;

import com.c0720i2.melody.model.Singer;
import com.c0720i2.melody.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SingerService implements ISingerService {

    @Autowired
    private SingerRepository singerRepository;

    @Override
    public Optional<Singer> findById(Long id) {
        return singerRepository.findById(id);
    }

    @Override
    public Iterable<Singer> findAll() {
        return singerRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        singerRepository.findAll();
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }
}
