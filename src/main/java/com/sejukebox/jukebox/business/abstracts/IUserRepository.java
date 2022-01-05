package com.sejukebox.jukebox.business.abstracts;

import com.sejukebox.jukebox.dtos.AddUserDto;
import com.sejukebox.jukebox.models.User;

import java.util.List;

public interface IUserRepository {

    List<User> findAll();

    User add(AddUserDto addUserDto);

    User userLogin(String userName,String password);

    User hostLogin(String email,String password);

    int generateCode(long hostId);
}
