package com.sejukebox.jukebox.controllers;

import com.sejukebox.jukebox.data.abstracts.IUserRepository;
import com.sejukebox.jukebox.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController{

    private IUserRepository userRepository;

    @Autowired
    public UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/getall")
    List<User> getAll(){
        return userRepository.findAll();
    }
}
