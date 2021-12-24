package com.sejukebox.jukebox.data.abstracts;

import com.sejukebox.jukebox.dtos.AddUserDto;
import com.sejukebox.jukebox.models.User;

import java.util.List;

public interface IUserRepository {

    List<User> findAll();

    User add(AddUserDto addUserDto);
}
