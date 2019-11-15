package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.entity.UserEntity;
import com.deneme.Korku.Hikayeleri.repository.UserRepository;
import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import com.deneme.Korku.Hikayeleri.shared.dto.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {

        if (userRepository.findByEmail(userDto.getEmail()) != null)
            throw new RuntimeException("Record already exists.");

        if (userRepository.findByUserName(userDto.getUserName())!=null)
            throw new RuntimeException("This user name already exists.");

        UserEntity userEntity = new UserEntity();

        BeanUtils.copyProperties(userDto, userEntity);


        //İstediğimiz uzunlukta random userId oluşturmak için
        String publicUserId = utils.generateUserId(30);
        userEntity.setUserId(publicUserId);


        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        UserEntity storedUserEntity = userRepository.save(userEntity);

        UserDto dto = new UserDto();

        BeanUtils.copyProperties(storedUserEntity, dto);

        return dto;
    }

    @Override
    public UserDto getUser(String userName) {

        UserEntity userEntity = userRepository.findByUserName(userName);
        if (userEntity==null) throw new UsernameNotFoundException(userName);


        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity,returnValue);
        return returnValue;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity =userRepository.findByUserName(userName);
        if (userEntity==null) throw new UsernameNotFoundException(userName);

        return new User(userEntity.getUserName(),userEntity.getEncryptedPassword(),new ArrayList<>());
    }
}
