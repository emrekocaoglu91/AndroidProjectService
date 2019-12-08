package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.entity.UserEntity;
import com.deneme.Korku.Hikayeleri.exception.UserServiceException;
import com.deneme.Korku.Hikayeleri.model.response.ErrorMessages;
import com.deneme.Korku.Hikayeleri.repository.UserRepository;
import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import com.deneme.Korku.Hikayeleri.shared.dto.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            throw new UserServiceException(ErrorMessages.RECORD_EMAIL_ALREADY_EXISTS.getErrorMessage());

        if (userRepository.findByUserName(userDto.getUserName()) != null)
            throw new UserServiceException(ErrorMessages.RECORD_USERNAME_ALREADY_EXISTS.getErrorMessage());

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
        if (userEntity == null) throw new UsernameNotFoundException(userName);


        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);
        return returnValue;
    }

    @Override
    public UserDto getUserByUserId(String userId) throws Exception {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null) throw new Exception("User not found !");

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity, userDto);
        return userDto;
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) throws Exception {
        UserDto dto = new UserDto();
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null) throw new Exception(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());

        UserEntity updatedUser = userRepository.save(userEntity);
        BeanUtils.copyProperties(updatedUser, dto);

        return dto;
    }

    @Override
    public List<UserDto> getAllUsers(int page, int limit) {
        List<UserDto> userDtoList = new ArrayList<>();


        if (page>0) page=page-1;

        Pageable pageable = PageRequest.of(page, limit);
        Page<UserEntity> userEntityPage = userRepository.findAll(pageable);
        List<UserEntity> userEntityList = userEntityPage.getContent();

        for (UserEntity userEntity : userEntityList) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userEntity, userDto);
            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(userName);
        if (userEntity == null) throw new UsernameNotFoundException(userName);

        return new User(userEntity.getUserName(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }
}
