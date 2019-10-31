package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    public User save(User user);

    public void delete(User user);

    public User getUser(Long id);

    public List<User> getAllUsers();


}
