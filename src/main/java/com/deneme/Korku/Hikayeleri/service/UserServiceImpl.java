package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.model.User;
import com.deneme.Korku.Hikayeleri.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user){
        userRepository.delete(user);
    }

    @Override
    public User getUser(Long id) {
        User user = userRepository.getOne(id);
            if (user.getId() != 0) {
                return user;
            }else {
                return null;
            }

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllByIsActive('Y');
    }
}
