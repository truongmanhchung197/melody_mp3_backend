package com.c0720i2.melody.repository;

import com.c0720i2.melody.model.Song;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface LikeSongRepository extends CrudRepository<Song, Long> {
    @Query(value = "select id from song\n" +
            "    join (select count(user_id) as like_number, song_id\n" +
            "    from like_song group by song_id order by like_number desc)\n" +
            "        likesong where id = likesong.song_id\n" +
            "order by likesong.like_number desc limit 5", nativeQuery = true)
    Iterable<BigInteger> findAllByUserLike();

}
