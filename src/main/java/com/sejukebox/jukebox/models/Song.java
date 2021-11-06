package com.sejukebox.jukebox.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "songs")
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private long songId;

    @Column(name = "song_name")
    private String songName;

    @Column(name = "singer")
    private String singer;

    @Column(name = "owner_id")
    private long ownerId;
}
