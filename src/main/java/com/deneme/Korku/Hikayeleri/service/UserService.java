package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

     UserDto createUser(UserDto userDto);

     UserDto getUser(String userName);

     UserDto getUserByUserId(String userId) throws Exception;

     UserDto updateUser(String userId, UserDto userDto) throws Exception;

     List<UserDto> getAllUsers(int page, int limit);

     boolean verifyEmailToken(String token);

     boolean requestPasswordReset(String email);

     boolean resetPassword(String token, String password);
}
