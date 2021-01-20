package com.c0720i2.melody.controller;

import com.c0720i2.melody.model.CommentSong;
import com.c0720i2.melody.model.Song;
import com.c0720i2.melody.service.commentSong.CommentSongService;
import com.c0720i2.melody.service.song.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CommentSongController {

    @Autowired
    private CommentSongService commentSongService;

    @Autowired
    private SongService songService;

    @GetMapping("/commentSong/{songID}")
    public ResponseEntity<Iterable<CommentSong>> getCommentByIdSong(@PathVariable Long songID){
        Song song = songService.findById(songID);
        Iterable<CommentSong> listCommentSong = commentSongService.getCommentSongsBySong(song);
        return new ResponseEntity<>(listCommentSong, HttpStatus.OK);
    }

}
