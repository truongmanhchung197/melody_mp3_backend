package com.c0720i2.melody.controller;

import com.c0720i2.melody.service.commentSong.CommentSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CommentSongController {

    @Autowired
    private CommentSongService commentSongService;

//    GetMapping("/commentsong/")

}
