package com.sejukebox.jukebox.business.concretes;

import com.sejukebox.jukebox.business.abstracts.IVoteRepository;
import com.sejukebox.jukebox.dataAccess.VoteDao;
import com.sejukebox.jukebox.dtos.AddVoteDto;
import com.sejukebox.jukebox.models.Song;
import com.sejukebox.jukebox.models.Vote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteRepository implements IVoteRepository {

    VoteDao voteDao;

    public VoteRepository(VoteDao voteDao) {
        this.voteDao = voteDao;
    }

    @Override
    public List<Vote> findAll() {
        return this.voteDao.findAll();
    }

    @Override
    public List<Vote> findBySongsVote(long songId) {
        return this.voteDao.findBySongsVote(songId);
    }

    @Override
    public List<Vote> findByUsersVote(long usersId) {
        return this.voteDao.findByUsersVote(usersId);
    }

    @Override
    public Vote createVote(AddVoteDto addVoteDto) {

        Vote vote=new Vote(
                addVoteDto.getSongsVote(),
                addVoteDto.getUsersVote());

        this.voteDao.save(vote);
        return vote;
    }




}
