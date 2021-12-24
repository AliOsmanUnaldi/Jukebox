package com.sejukebox.jukebox.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddUserDto {

    private String userName;

    private String password;

    private String email;

}
