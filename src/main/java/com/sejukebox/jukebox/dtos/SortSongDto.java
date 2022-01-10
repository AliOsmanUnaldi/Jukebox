package com.sejukebox.jukebox.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SortSongDto {

    private String songName;
    private String singer;
    private long ownerId;
    private int code;
    private int numberOfTotalVotes;

}
