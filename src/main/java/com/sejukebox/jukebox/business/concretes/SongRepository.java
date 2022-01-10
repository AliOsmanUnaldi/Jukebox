package com.sejukebox.jukebox.business.concretes;

import com.sejukebox.jukebox.business.abstracts.ISongRepository;
import com.sejukebox.jukebox.dataAccess.SongDao;
import com.sejukebox.jukebox.dataAccess.VoteDao;
import com.sejukebox.jukebox.dtos.AddSongDto;
import com.sejukebox.jukebox.dtos.SortSongDto;
import com.sejukebox.jukebox.models.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
                addSongDto.getCode();
        return this.songDao.save(song);
    }

    @Override
    public void deleteBySongId(long songId) {

         voteDao.deleteAll(this.voteDao.findBySongsVote(songId));
         this.songDao.deleteById(songId);
    }

    @Override
    public String finishVoting(long ownerId) {

        List<Song> songList=songDao.findByOwnerId(ownerId);
        for (int i=0;i<songList.size();i++){
            songList.get(i).setCode(1597532148);
        }
        return "Oylama süresi sona erdi.";
    }

    @Override
    public List<SortSongDto> sortSongs(long ownerId) {

        List<SortSongDto> sortedSongs = new ArrayList<>(songDao.findByOwnerId(ownerId).size()-1);

        for (int i=0;i<songDao.findByOwnerId(ownerId).size();i++){

            List<Song> x = songDao.findByOwnerId(ownerId);

            long sId = x.get(i).getSongId();

            SortSongDto sortSongDto = new SortSongDto();
            sortSongDto.setSongName(x.get(i).getSongName());
            sortSongDto.setSinger(x.get(i).getSinger());
            sortSongDto.setOwnerId(sId);
            sortSongDto.setCode(x.get(i).getCode());
            sortSongDto.setNumberOfTotalVotes(voteDao.findBySongsVote(sId).size());

            sortedSongs.add(sortSongDto);

        }

        Collections.sort(sortedSongs, new Comparator<SortSongDto>() {
            @Override
            public int compare(SortSongDto o1, SortSongDto o2) {
                return o2.getNumberOfTotalVotes()- o1.getNumberOfTotalVotes();
            }
        });

        return sortedSongs;
    }

    @Override
    public List<Song> findByCode(int code) {
        return songDao.findByCode(code);
    }


}
