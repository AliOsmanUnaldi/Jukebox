package com.sejukebox.jukebox.controllers;

import com.sejukebox.jukebox.data.abstracts.ISongRepository;
import com.sejukebox.jukebox.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/songs")
public class SongController {

    private ISongRepository songRepository;

    @Autowired
    public SongController(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/getall")
    List<Song> getAll(){
        return songRepository.findAll();
    }

    @GetMapping("/getbysongid")
    public Song findBySongId(@RequestParam long songId){
        return this.songRepository.findBySongId(songId);
    }

    @GetMapping("/getbyownerid")
    public List<Song> findByOwnerId(@RequestParam long ownerId){
        return this.songRepository.findByOwnerId(ownerId);
    }

}
