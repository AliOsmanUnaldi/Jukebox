package com.sejukebox.jukebox.controllers;

import com.sejukebox.jukebox.data.abstracts.IUserRepository;
import com.sejukebox.jukebox.dtos.AddUserDto;
import com.sejukebox.jukebox.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController{

    private IUserRepository userRepository;

    @Autowired
    public UserController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/getAll")
    List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping("/addUser")
    User addUser(AddUserDto addUserDto){
        return userRepository.add(addUserDto);
    }



}
