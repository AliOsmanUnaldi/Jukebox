package com.sejukebox.jukebox.data.concretes;

import com.sejukebox.jukebox.data.abstracts.ISongRepository;
import com.sejukebox.jukebox.dataAccess.SongDao;
import com.sejukebox.jukebox.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongRepository implements ISongRepository {

    SongDao songDao;

    @Autowired
    public SongRepository(SongDao songDao) {
        this.songDao = songDao;
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


}
