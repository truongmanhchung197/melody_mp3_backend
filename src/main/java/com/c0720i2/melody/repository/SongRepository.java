package com.c0720i2.melody.repository;

import com.c0720i2.melody.model.Song;
import com.c0720i2.melody.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
    @Query(value = "select * from song order by creation_time desc limit 5", nativeQuery = true)
    Iterable<Song> findAllByCreationTimeOrderByCreationTime();
    Iterable<Song> findAllByUserId(Long id);
}
