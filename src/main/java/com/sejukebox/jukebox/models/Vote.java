package com.sejukebox.jukebox.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "votes")
@AllArgsConstructor
@NoArgsConstructor
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id")
    private long voteId;

    @Column(name = "song_id")
    private long songsVote;

    @Column(name = "user_id")
    private long usersVote;

    public Vote(long songsVote, long usersVote) {
        this.songsVote = songsVote;
        this.usersVote = usersVote;
    }
}
