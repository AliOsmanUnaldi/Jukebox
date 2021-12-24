package com.sejukebox.jukebox.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddSongDto {

    private String songName;

    private String singer;

    private long ownerId;
}
