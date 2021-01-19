package com.c0720i2.melody.repository;

import com.c0720i2.melody.model.Playlist;
import com.c0720i2.melody.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayListRepository extends JpaRepository<Playlist, Long> {
    Iterable<Playlist> findAllByUserUsername(String username);

    @Query(value = "select * from playlist order by creation_time desc limit 10", nativeQuery = true)
    Iterable<Playlist> findAllByCreationTimeOrderByCreationTime();
}

