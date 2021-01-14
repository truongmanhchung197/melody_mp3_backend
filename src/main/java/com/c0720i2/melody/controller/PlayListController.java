package com.c0720i2.melody.controller;

import com.c0720i2.melody.model.Playlist;
import com.c0720i2.melody.service.playlist.IPlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/playlists")
public class PlayListController {
    @Autowired
    IPlayListService playListService;

    @GetMapping("")
    public ResponseEntity<Iterable<Playlist>> getAll(){
        return new ResponseEntity<>(playListService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlayListById(@PathVariable Long id){
        Optional<Playlist> playlistOptional = playListService.findById(id);
        return playlistOptional.map(playlist -> new ResponseEntity<>(playlist, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    Date currentTime = Calendar.getInstance().getTime();
    @PostMapping("")
    public ResponseEntity<Playlist> createNewPlayList(@RequestBody Playlist playlist){
        playlist.setCreationTime(currentTime);
        return new ResponseEntity<>(playListService.save(playlist), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlayList(@PathVariable Long id, @RequestBody Playlist playlist){
        Optional<Playlist> playlistOptional = playListService.findById(id);
        return playlistOptional.map(playlist1 -> {
            playlist.setId(playlist1.getId());
            if (playlist.getName().equalsIgnoreCase("")){
                playlist.setName(playlist1.getName());
            }
            return new ResponseEntity<>(playListService.save(playlist), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<Playlist> deletePlayList(@PathVariable Long id){
        Optional<Playlist> playlistOptional = playListService.findById(id);
        return playlistOptional.map(playlist -> {
            playListService.remove(id);
            return new ResponseEntity<Playlist>(HttpStatus.NO_CONTENT);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
}