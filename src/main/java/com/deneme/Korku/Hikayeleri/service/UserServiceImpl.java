package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.entity.UserEntity;
import com.deneme.Korku.Hikayeleri.repository.UserRepository;
import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userDto, userEntity);

        userEntity.setEncryptedPassword("test");
        userEntity.setUserId("testUserId");


        UserEntity storedUserEntity = userRepository.save(userEntity);

        UserDto dto = new UserDto();

        BeanUtils.copyProperties(storedUserEntity,dto);

        return dto;
    }

}
