package com.sejukebox.jukebox.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddVoteDto {

    private long songsVote;

    private long usersVote;
}
