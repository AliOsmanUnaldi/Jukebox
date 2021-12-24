package com.sejukebox.jukebox.data.concretes;

import com.sejukebox.jukebox.data.abstracts.IUserRepository;
import com.sejukebox.jukebox.dataAccess.UserDao;
import com.sejukebox.jukebox.dtos.AddUserDto;
import com.sejukebox.jukebox.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepository implements IUserRepository {

    UserDao userDao;

    @Autowired
    public UserRepository(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User add(AddUserDto addUserDto) {

        User user = new User(
                addUserDto.getUserName(),
                addUserDto.getPassword(),
                addUserDto.getEmail());

        userDao.save(user);

        return user;
    }

}
