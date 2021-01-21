package com.c0720i2.melody.controller;

import com.c0720i2.melody.model.CommentPlaylist;
import com.c0720i2.melody.model.Playlist;
import com.c0720i2.melody.service.commentPlaylist.CommentPlaylistService;
import com.c0720i2.melody.service.playlist.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class CommentPlaylistController {
    @Autowired
    private PlayListService playListService;

    @Autowired
    private CommentPlaylistService commentPlaylistService;

    @GetMapping("/commentPlaylist/{idPlaylist}")
    public ResponseEntity<Iterable<CommentPlaylist>> getCommentByIdPlaylist(@PathVariable Long idPlaylist){
        Optional<Playlist> playlist = playListService.findById(idPlaylist);
        Iterable<CommentPlaylist> listCommentPlaylist = commentPlaylistService.getCommentPlaylistsByPlaylist(playlist.get());
        return new ResponseEntity<>(listCommentPlaylist, HttpStatus.OK);

    }
}
