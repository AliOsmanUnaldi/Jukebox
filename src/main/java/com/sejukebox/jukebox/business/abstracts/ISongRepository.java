package com.sejukebox.jukebox.business.abstracts;

import com.sejukebox.jukebox.dtos.AddSongDto;
import com.sejukebox.jukebox.dtos.SortSongDto;
import com.sejukebox.jukebox.models.Song;

import java.util.List;

public interface ISongRepository {

    List<Song> findAll();
    Song findBySongId(long songId);
    List<Song> findByOwnerId(long ownerId);
    Song add(AddSongDto addSongDto);
    void deleteBySongId(long songId);
    String finishVoting(long ownerId);
    List<SortSongDto> sortSongs(long ownerId);
    List<Song> findByCode(int code);
}
