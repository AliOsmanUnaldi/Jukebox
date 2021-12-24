package com.sejukebox.jukebox.dataAccess;

import com.sejukebox.jukebox.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {

    User getByUserId(long userId);
}
