package com.c0720i2.melody.repository;

import com.c0720i2.melody.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
}
