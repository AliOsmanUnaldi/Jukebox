package com.sejukebox.jukebox.controllers;

import com.sejukebox.jukebox.data.abstracts.IVoteRepository;
import com.sejukebox.jukebox.dtos.AddVoteDto;
import com.sejukebox.jukebox.models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    private IVoteRepository voteRepository;

    @Autowired
    public VoteController(IVoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @GetMapping("/getBySongsVote")
    public int findBySongsVote(@RequestParam long songsVote){
        return this.voteRepository.findBySongsVote(songsVote).size();
    }

    @GetMapping("/getByUsersVote")
    public List<Vote> findByUsersVote(@RequestParam long usersVote){
        return this.voteRepository.findByUsersVote(usersVote);
    }

    @PostMapping("/addVote")
    public Vote addVote(@RequestBody AddVoteDto addVoteDto){
        return this.voteRepository.createVote(addVoteDto);
    }
}
