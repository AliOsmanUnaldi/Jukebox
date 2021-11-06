package com.sejukebox.jukebox.data.concretes;

import com.sejukebox.jukebox.data.abstracts.IVoteRepository;
import com.sejukebox.jukebox.dataAccess.VoteDao;
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
    public List<Vote> findBySongsVote(long songsVote) {
        return this.voteDao.findBySongsVote(songsVote);
    }

    @Override
    public List<Vote> findByUsersVote(long usersVote) {
        return this.voteDao.findByUsersVote(usersVote);
    }

}
