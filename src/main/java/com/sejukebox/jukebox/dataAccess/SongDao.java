package com.sejukebox.jukebox.dataAccess;

import com.sejukebox.jukebox.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongDao extends JpaRepository<Song,Long> {

    Song findBySongId(long songId);
    List<Song> findByOwnerId(long ownerId);
    List<Song> findByCode(int code);
}
