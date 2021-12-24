package com.sejukebox.jukebox.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "songs")
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "song_id",unique = true)
    @NotNull
    @NotBlank
    private long songId;

    public Song(String songName, String singer, long ownerId) {
        this.songName = songName;
        this.singer = singer;
        this.ownerId = ownerId;
    }

    @Column(name = "song_name")
    private String songName;

    @Column(name = "singer")
    private String singer;

    @Column(name = "owner_id")
    private long ownerId;
}
