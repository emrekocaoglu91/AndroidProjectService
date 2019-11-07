package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public UserDto createUser(UserDto userDto);



}
