package com.sejukebox.jukebox.business.concretes;

import com.sejukebox.jukebox.business.abstracts.IUserRepository;
import com.sejukebox.jukebox.dataAccess.SongDao;
import com.sejukebox.jukebox.dataAccess.UserDao;
import com.sejukebox.jukebox.dtos.AddUserDto;
import com.sejukebox.jukebox.models.Song;
import com.sejukebox.jukebox.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UserRepository implements IUserRepository {

    UserDao userDao;
    SongDao songDao;

    @Autowired
    public UserRepository(UserDao userDao,SongDao songDao) {
        this.userDao = userDao;
        this.songDao = songDao;
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

    @Override
    public User userLogin(String userName, String password) {
        try {
            return userDao.getByUserNameAndPassword(userName,password);
        }
         catch (Exception e){
             new Exception("Kullanıcı bulunamadı!");
         }
        return null;
    }

    @Override
    public User hostLogin(String email, String password) {
        try {
            User user=userDao.getByEmailAndPassword(email,password);

            if (user.isHost()){

            return userDao.getByEmailAndPassword(email,password);

            }
            else System.out.println("Kullanıcı host rolünde değil!");
        }

        catch (Exception e){
             e.getMessage();
        }
        return null;
    }

    @Override
    public int generateCode(long hostId) {

        Random r = new Random( System.currentTimeMillis() );
        int code=10000 + r.nextInt(20000);

        for (int i=0;i<songDao.findByOwnerId(hostId).size();i++){

            songDao.findByOwnerId(hostId).get(i).setCode(code);
            songDao.save(songDao.findByOwnerId(hostId).get(i));
        }

        return code;
    }


}
