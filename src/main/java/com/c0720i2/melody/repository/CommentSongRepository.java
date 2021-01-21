package com.c0720i2.melody.repository;

import com.c0720i2.melody.model.CommentSong;
import com.c0720i2.melody.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentSongRepository extends JpaRepository<CommentSong,Long> {
    Iterable<CommentSong> getCommentSongsBySongOrderByCreationTimeDesc(Song song);
    /*@Query(value = "select * from CommentSong order by creationTime desc limit 5",nativeQuery = true)
    Iterable<CommentSong> findAllByCreationTimeOrderByCreationTime();*/
}
