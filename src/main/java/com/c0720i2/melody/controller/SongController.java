package com.c0720i2.melody.controller;

import com.c0720i2.melody.model.Song;
import com.c0720i2.melody.service.SongService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/song/")
@CrossOrigin("*")
public class SongController {
    @Autowired
    SongService songService;
    Date currentTime = Calendar.getInstance().getTime();

    @ApiOperation(value = "Create Song", response = Song.class)
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Song> create(@RequestBody Song song){
        song.setCreationTime(currentTime);
        songService.save(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }
}
