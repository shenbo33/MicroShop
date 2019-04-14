package com.lions.shen60.body.service;

import com.lions.shen60.body.dao.UserRepository;
import com.lions.shen60.body.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserByName(String name) {
        User user = null;
        try {
            user = userRepository.findUserByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Transactional
    public User addUser(User user){
        User resUser = null;
        try {
            resUser = userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resUser;
    }

}
