package com.sejukebox.jukebox.controllers;

import com.sejukebox.jukebox.business.abstracts.IUserRepository;
import com.sejukebox.jukebox.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    private IUserRepository userRepository;

    @Autowired
    public HomeController(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/userLogin")
    public User userLogin(String userName,String password){
        return userRepository.userLogin(userName,password);
    }

    @GetMapping("/hostLogin")
    public User hostLogin(String email,String password){
        return userRepository.hostLogin(email,password);
    }

    @GetMapping("/generateCode")
    public int generateCode(@RequestParam long hostId){
        return userRepository.generateCode(hostId);
    }


}
