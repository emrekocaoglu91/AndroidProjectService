package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public UserDto createUser(UserDto userDto);

    public UserDto getUser(String userName);

    public UserDto getUserByUserId(String userId) throws Exception;

    public UserDto updateUser(String userId, UserDto userDto) throws Exception;

    public List<UserDto> getAllUsers(int page, int limit);
}
