package com.c0720i2.melody.repository;

import com.c0720i2.melody.model.CommentSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentSongRepository extends JpaRepository<CommentSong,Long> {
}
