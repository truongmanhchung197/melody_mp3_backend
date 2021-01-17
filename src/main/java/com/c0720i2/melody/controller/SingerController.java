package com.c0720i2.melody.controller;

import com.c0720i2.melody.model.Singer;
import com.c0720i2.melody.model.Singer;
import com.c0720i2.melody.service.playlist.IPlayListService;
import com.c0720i2.melody.service.singer.ISingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    ISingerService singerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Singer>> getAll(){
        return new ResponseEntity<>(singerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Singer> getSingerById(@PathVariable Long id){
        Optional<Singer> singerOptional = singerService.findById(id);
        return singerOptional.map(singer -> new ResponseEntity<>(singer, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping("")
    public ResponseEntity<Singer> createNewSinger(@RequestBody Singer singer){
        return new ResponseEntity<>(singerService.save(singer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Singer> updateSinger(@PathVariable Long id, @RequestBody Singer singer){
        Optional<Singer> singerOptional = singerService.findById(id);
        return singerOptional.map(singer1 -> {
            singer.setId(singer1.getId());
            if (singer.getName().equalsIgnoreCase("")){
                singer.setName(singer1.getName());
            }
            return new ResponseEntity<>(singerService.save(singer), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Singer> deleteSinger(@PathVariable Long id){
        Optional<Singer> singerOptional = singerService.findById(id);
        return singerOptional.map(singer -> {
            singerService.remove(id);
            return new ResponseEntity<Singer>(HttpStatus.NO_CONTENT);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
