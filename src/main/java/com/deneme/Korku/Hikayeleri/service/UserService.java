package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public UserDto createUser(UserDto userDto);

    public UserDto getUser(String userName);



}
