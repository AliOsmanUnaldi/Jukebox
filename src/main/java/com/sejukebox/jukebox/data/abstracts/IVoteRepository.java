package com.sejukebox.jukebox.data.abstracts;

import com.sejukebox.jukebox.dtos.AddVoteDto;
import com.sejukebox.jukebox.models.Vote;

import java.util.List;

public interface IVoteRepository {

    List<Vote> findAll();
    List<Vote> findBySongsVote(long songsVote);
    List<Vote> findByUsersVote(long usersVote);
    Vote createVote(AddVoteDto addVoteDto);
}
