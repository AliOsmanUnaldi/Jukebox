package com.sejukebox.jukebox.data.concretes;

import com.sejukebox.jukebox.data.abstracts.ISongRepository;
import com.sejukebox.jukebox.dataAccess.SongDao;
import com.sejukebox.jukebox.dataAccess.VoteDao;
import com.sejukebox.jukebox.dtos.AddSongDto;
import com.sejukebox.jukebox.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongRepository implements ISongRepository {

    SongDao songDao;
    VoteDao voteDao;

    @Autowired
    public SongRepository(SongDao songDao,VoteDao voteDao) {
        this.songDao = songDao;
        this.voteDao=voteDao;
    }

    @Override
    public List<Song> findAll() {
        return songDao.findAll();
    }

    @Override
    public Song findBySongId(long songId) {
        return this.songDao.findBySongId(songId);
    }

    @Override
    public List<Song> findByOwnerId(long ownerId) {
        return this.songDao.findByOwnerId(ownerId);
    }

    @Override
    public Song add(AddSongDto addSongDto) {
        Song song=new Song(
                addSongDto.getSongName(),
                addSongDto.getSinger(),
                addSongDto.getOwnerId());
        return this.songDao.save(song);
    }

    @Override
    public void deleteBySongId(long songId) {
         voteDao.deleteAll(this.voteDao.findBySongsVote(songId));
         this.songDao.deleteById(songId);
    }


}
