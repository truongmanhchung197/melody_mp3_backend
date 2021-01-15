package com.c0720i2.melody.controller;

import com.c0720i2.melody.model.Song;
import com.c0720i2.melody.service.song.SongService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/songs/")
@CrossOrigin("*")
public class SongController {
    @Autowired
    SongService songService;
    Date currentTime = Calendar.getInstance().getTime();

    @ApiOperation(value = "Create Song", response = Song.class)
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Song> create(@RequestBody Song song) {
        song.setCreationTime(currentTime);
        songService.save(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @ApiOperation(value = "show list latest songs", response = Song.class)
    @RequestMapping(value = "latestSongs", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Song>> listLatestSong() {
        Iterable<Song> songs = songService.listLatest();
        if (songs == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @ApiOperation(value = "show detail song by id", response = Song.class)
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Song> getSongById(@PathVariable Long id) {
        Song song = songService.findById(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }












    @ApiOperation(value = "show all songs created by user")
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Song>> listSongsByUser(@PathVariable Long id){
        Iterable<Song> songs = songService.listSongsByUser(id);
        if (songs == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @ApiOperation(value = "find by name", response = Song.class)
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Song>> searchByName(String keyword){
        Iterable<Song> songs = songService.findByName(keyword);
        if (songs == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @ApiOperation(value = "delete song created by user", response = Song.class)
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSong(@PathVariable("id") Long id){
        Song song = songService.findById(id);
        if (song == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        songService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
