package com.sejukebox.jukebox.business.abstracts;

import com.sejukebox.jukebox.dtos.AddVoteDto;
import com.sejukebox.jukebox.models.Song;
import com.sejukebox.jukebox.models.Vote;

import java.util.List;

public interface IVoteRepository {

    List<Vote> findAll();
    List<Vote> findBySongsVote(long songId);
    List<Vote> findByUsersVote(long usersId);
    Vote createVote(AddVoteDto addVoteDto);

}
