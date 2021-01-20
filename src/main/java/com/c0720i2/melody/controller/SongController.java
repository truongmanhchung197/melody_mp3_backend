package com.c0720i2.melody.controller;

import com.c0720i2.melody.model.*;
import com.c0720i2.melody.service.likesong.LikeSongService;
import com.c0720i2.melody.service.song.SongService;
import com.c0720i2.melody.service.user.IUserService;
import com.c0720i2.melody.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class SongController {
    @Autowired
    SongService songService;

    @Autowired
    IUserService userService;
    @Autowired
    LikeSongService likeSongService;
    Date currentTime = Calendar.getInstance().getTime();

    @ApiOperation(value = "Create Song", response = Song.class)
    @PostMapping("/createsong/{username}")
    public ResponseEntity<Song> create(@RequestBody Song song, @PathVariable String username) {
        song.setCreationTime(currentTime);
        song.setNumberOfView(0L);
        User user = userService.findByUsername(username);
        song.setUser(user);
        songService.save(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @ApiOperation(value = "show list latest songs", response = Song.class)
    @RequestMapping(value = "/latestSongs", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Song>> listLatestSong() {
        Iterable<Song> songs = songService.listLatest();
        if (songs == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @ApiOperation(value = "show detail song by id", response = Song.class)
    @GetMapping("/editsong/{username}/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable Long id, @PathVariable String username) {
        Song song = songService.findById(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }
    @PutMapping("/editsong/{username}/{id}")
    public ResponseEntity<Song> editSong(@RequestBody Song song, @PathVariable Long id, @PathVariable String username) {
        if (songService.findById(id) != null) {
            songService.save(song);
        }
        return new ResponseEntity<>(song, HttpStatus.OK);
    }
    @GetMapping("/listsong/{username}")
    public ResponseEntity<Iterable<Song>> getSongByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        Iterable<Song> listSong = songService.findAllByUserId(user.getId());
        return new ResponseEntity<>(listSong, HttpStatus.OK);
    }


    @ApiOperation(value = "find by name", response = Song.class)
    @RequestMapping(value = "search/{keyword}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Song>> searchByName(@PathVariable String keyword){
        Iterable<Song> songs = songService.findByName(keyword);
        if (songs == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songs, HttpStatus.OK);
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

    @ApiOperation(value = "delete song created by user", response = Song.class)
    @RequestMapping(value = "listsong/{username}/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSong(@PathVariable("id") Long id){
        Song song = songService.findById(id);
        if (song == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        songService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("top10views")
    public ResponseEntity<Iterable<Song>>getList10SongInTopView(){
        Iterable<Song> songs=songService.getList10SongInTopView();
        if(songs==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(songs,HttpStatus.OK);
    }
    @GetMapping("/songs/{id}")
    public ResponseEntity<Song> getSongByIdSong(@PathVariable Long id){
        Song song = songService.findById(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }
    @PutMapping("/songs/addView/{idSong}")
    public ResponseEntity<Song> addViewSong(@PathVariable Long idSong) {
        Song song = songService.findById(idSong);
        Long views = song.getNumberOfView();
        song.setNumberOfView(views + 1);
        return new ResponseEntity<>(songService.save(song), HttpStatus.OK);
    }

    @GetMapping("/topLikeSong")
    public ResponseEntity<Iterable<Song>> topLikeSong(){
        Iterable<Song> songs = songService.topLikeSong();
        if (songs == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(songs,HttpStatus.OK);
    }
    @PostMapping("/songs/addLike/{idSong}/user/{idUser}")
    public ResponseEntity<LikeSong> addLikeSong(@PathVariable("idSong") Long idSong, @PathVariable("idUser") Long idUser){
        Song song = songService.findById(idSong);
        User user = userService.findById(idUser).get();
        LikeSongId likeSongId = new LikeSongId(song,user);
        LikeSong likeSong = new LikeSong(likeSongId);
        return new ResponseEntity<>(likeSongService.save(likeSong), HttpStatus.CREATED);
    }
    @DeleteMapping("/songs/deleteLike/{idSong}/user/{idUser}")
    public ResponseEntity<LikeSong> deleteLikeSong(@PathVariable("idSong") Long idSong, @PathVariable("idUser") Long idUser){
        Song song = songService.findById(idSong);
        User user = userService.findById(idUser).get();
        LikeSongId likeSongId = new LikeSongId(song, user);
        Optional<LikeSong> likeSongOptional = likeSongService.findById(likeSongId);
        return likeSongOptional.map(likeSong -> {
            likeSongService.delete(likeSongId);
            return new ResponseEntity<LikeSong>(HttpStatus.NO_CONTENT);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
