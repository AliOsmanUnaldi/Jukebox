package com.sejukebox.jukebox.data.abstracts;

import com.sejukebox.jukebox.models.Song;

import java.util.List;

public interface ISongRepository {

    List <Song> findAll();
    Song findBySongId(long songId);
    List<Song> findByOwnerId(long ownerId);
}
