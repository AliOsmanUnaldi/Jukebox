package com.sejukebox.jukebox.dataAccess;

import com.sejukebox.jukebox.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteDao extends JpaRepository<Vote,Long> {

    List<Vote> findBySongsVote(long songsId);
    List<Vote> findByUsersVote(long usersId);
}
