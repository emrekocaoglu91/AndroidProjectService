package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.entity.UserEntity;
import com.deneme.Korku.Hikayeleri.repository.UserRepository;
import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import com.deneme.Korku.Hikayeleri.shared.dto.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Override
    public UserDto createUser(UserDto userDto) {

        // Aynı kontrolü userName için de yapmalıyız.
        if (userRepository.findByEmail(userDto.getEmail()) != null)
            throw new RuntimeException("Record already exists.");

        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userDto, userEntity);


        //İstediğimiz uzunlukta random userId oluşturmak için

        String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);

        System.out.println("deneme");

        userEntity.setEncryptedPassword("test");
        UserEntity storedUserEntity = userRepository.save(userEntity);

        UserDto dto = new UserDto();

        BeanUtils.copyProperties(storedUserEntity, dto);

        return dto;
    }

}
