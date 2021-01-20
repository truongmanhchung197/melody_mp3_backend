package com.c0720i2.melody.controller;

import com.c0720i2.melody.model.Playlist;
import com.c0720i2.melody.model.Song;
import com.c0720i2.melody.model.User;
import com.c0720i2.melody.service.playlist.IPlayListService;
import com.c0720i2.melody.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/playlists")
public class PlayListController {
    @Autowired
    IPlayListService playListService;

    @Autowired
    IUserService userService;

    @GetMapping("")
    public ResponseEntity<Iterable<Playlist>> getAll() {
        return new ResponseEntity<>(playListService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlayListById(@PathVariable Long id) {
        Optional<Playlist> playlistOptional = playListService.findById(id);
        return playlistOptional.map(playlist -> new ResponseEntity<>(playlist, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("")
    public ResponseEntity<Playlist> createNewPlayList(@RequestBody Playlist playlist) {
        Date currentTime = Calendar.getInstance().getTime();
        playlist.setCreationTime(currentTime);
        return new ResponseEntity<>(playListService.save(playlist), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlayList(@PathVariable Long id, @RequestBody Playlist playlist) {
        Optional<Playlist> playlistOptional = playListService.findById(id);
        return playlistOptional.map(playlist1 -> {
            playlist.setId(playlist1.getId());
            if (playlist.getName().equalsIgnoreCase("")) {
                playlist.setName(playlist1.getName());
            }
            return new ResponseEntity<>(playListService.save(playlist), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> deletePlayList(@PathVariable Long id) {
        Optional<Playlist> playlistOptional = playListService.findById(id);
        return playlistOptional.map(playlist -> {
            playListService.remove(id);
            return new ResponseEntity<Playlist>(HttpStatus.NO_CONTENT);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<Iterable<Playlist>> findAllByUserUsername(@PathVariable String username) {
        Iterable<Playlist> playlists = playListService.findAllByUserUsername(username);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @PostMapping("/user/{username}")
    public ResponseEntity<Playlist> createNewPlayListByUser(@RequestBody Playlist playlist, @PathVariable String username){
        User user = userService.findByUsername(username);
        Date currentTime = Calendar.getInstance().getTime();
        playlist.setCreationTime(currentTime);
        return new ResponseEntity<>(playListService.save(playlist), HttpStatus.CREATED);
    }

    @PutMapping("/user/{username}/playlist/{idPlaylist}")
    public ResponseEntity<Playlist> updatePlayListByUser(@PathVariable String username, @RequestBody Playlist playlist, @PathVariable Long idPlaylist){
        Optional<Playlist> playlistOptional = playListService.findById(idPlaylist);
        return playlistOptional.map(playlist1 -> {
            playlist.setId(playlist1.getId());
            if (playlist.getName().equalsIgnoreCase("")){
                playlist.setName(playlist1.getName());
            }
            return new ResponseEntity<>(playListService.save(playlist), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/user/{username}/playlist/{idPlaylist}")
    public ResponseEntity<Playlist> deletePlayListByUser(@PathVariable Long idPlaylist, @PathVariable String username){
        Optional<Playlist> playlistOptional = playListService.findById(idPlaylist);
        return playlistOptional.map(playlist -> {
            playListService.remove(idPlaylist);
            return new ResponseEntity<Playlist>(HttpStatus.NO_CONTENT);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{idPlaylist}/songs/{idSong}")
    public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable("idPlaylist") Long idPlaylist, @PathVariable("idSong") Long idSong) {
        return new ResponseEntity<>(playListService.addSongToPlaylist(idSong, idPlaylist), HttpStatus.OK);
    }

    @GetMapping("/latestPlaylists")
    public ResponseEntity<Iterable<Playlist>> latestPlaylist(){
        Iterable<Playlist> playlists = playListService.listLatest();
        if (playlists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/topView")
    public ResponseEntity<Iterable<Playlist>> topViewPlaylists(){
        Iterable<Playlist> playlists = playListService.topView();
        if (playlists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/topLike")
    public ResponseEntity<Iterable<Playlist>> topLikePlaylists(){
        Iterable<Playlist> playlists = playListService.topLike();
        if (playlists == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/likeNumber")
    public ResponseEntity<List<BigInteger>> topLikeNumber(){
        List<BigInteger> topLikeNumber = playListService.likeNumber();
        if (topLikeNumber == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(topLikeNumber, HttpStatus.OK);
    }
}
