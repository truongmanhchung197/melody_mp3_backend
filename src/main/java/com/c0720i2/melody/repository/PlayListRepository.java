package com.c0720i2.melody.repository;

import com.c0720i2.melody.model.Playlist;
import com.c0720i2.melody.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayListRepository extends JpaRepository<Playlist, Long> {
    Iterable<Playlist> findAllByUserUsername(String username);
}
