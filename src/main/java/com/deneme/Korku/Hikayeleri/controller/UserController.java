package com.deneme.Korku.Hikayeleri.controller;

import com.deneme.Korku.Hikayeleri.exception.UserServiceException;
import com.deneme.Korku.Hikayeleri.model.request.UserDetailRequestModel;
import com.deneme.Korku.Hikayeleri.model.response.ErrorMessages;
import com.deneme.Korku.Hikayeleri.model.response.UserRest;
import com.deneme.Korku.Hikayeleri.repository.UserRepository;
import com.deneme.Korku.Hikayeleri.service.UserService;
import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetailRequestModel)throws Exception {

        UserRest userRest = new UserRest();

        if (userDetailRequestModel.getEmail().isEmpty() || userDetailRequestModel.getFirstName().isEmpty() || userDetailRequestModel.getLastName().isEmpty() || userDetailRequestModel.getPassword().isEmpty() || userDetailRequestModel.getUserName().isEmpty())
            throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetailRequestModel, userDto);


        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, userRest);

        return userRest;
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UserRest getUser(@PathVariable String id) throws Exception {

        UserRest userRest = new UserRest();

        UserDto userDto = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto, userRest);

        return userRest;
    }

    @PutMapping(path = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailRequestModel userDetailRequestModel) throws Exception {
        UserRest userRest = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetailRequestModel, userDto);
        UserDto createdUser = userService.updateUser(id, userDto);
        BeanUtils.copyProperties(createdUser, userRest);
        return userRest;
    }

    /*
     * Bütün userları tek seferde getirmek yerine pagination yaparak getirir.
     * */
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE+"; charset=utf-8"})
    public List<UserRest> getUsers(@RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "limit", defaultValue = "25") int limit) {
        List<UserRest> userRestList = new ArrayList<>();

        List<UserDto> userDtoList = userService.getAllUsers(page, limit);

        for (UserDto userDto : userDtoList) {
            UserRest userRest = new UserRest();
            BeanUtils.copyProperties(userDto, userRest);
            userRestList.add(userRest);
        }
        return userRestList;
    }


}
