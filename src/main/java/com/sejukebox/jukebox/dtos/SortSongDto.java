package com.sejukebox.jukebox.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SortSongDto {
    private long songId;
    private int voteNumber;
}
