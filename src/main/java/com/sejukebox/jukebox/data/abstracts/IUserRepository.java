package com.sejukebox.jukebox.data.abstracts;

import com.sejukebox.jukebox.models.User;

import java.util.List;

public interface IUserRepository {

    List<User> findAll();
}
