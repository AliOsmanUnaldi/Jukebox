package com.sejukebox.jukebox.controllers;

import com.sejukebox.jukebox.business.abstracts.ISongRepository;
import com.sejukebox.jukebox.dtos.AddSongDto;
import com.sejukebox.jukebox.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/api/songs")
public class SongController {

    private ISongRepository songRepository;

    @Autowired
    public SongController(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/getAll")
    List<Song> getAll(){
        return songRepository.findAll();
    }

    @GetMapping("/findBySongId")
    public Song findBySongId(@RequestParam long songId){
        return this.songRepository.findBySongId(songId);
    }

    @GetMapping("/findByOwnerId")
    public List<Song> findByOwnerId(@RequestParam long ownerId){

        return this.songRepository.findByOwnerId(ownerId);
    }

    @PostMapping("/addOrUpdateSong")
    public Song addOrUpdateSong(@Valid @NotNull @RequestBody AddSongDto addSongDto){
        return this.songRepository.add(addSongDto);
    }

    @DeleteMapping("/deleteBySongId")
    public String deleteBySongId(long songId){
        this.songRepository.deleteBySongId(songId);
        return "SONG IS DELETED.";
    }

    @GetMapping("/finishVoting")
    public String finishVoting(@RequestParam long ownerId){
        return songRepository.finishVoting(ownerId);
    }

}
