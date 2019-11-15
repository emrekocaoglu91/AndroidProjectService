package com.deneme.Korku.Hikayeleri.controller;

import com.deneme.Korku.Hikayeleri.model.request.UserDetailRequestModel;
import com.deneme.Korku.Hikayeleri.model.response.UserRest;
import com.deneme.Korku.Hikayeleri.service.UserService;
import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, produces= APPLICATION_JSON_VALUE,consumes = APPLICATION_JSON_VALUE)
    public UserRest createUser(@RequestBody UserDetailRequestModel userDetailRequestModel) {

        UserRest userRest = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetailRequestModel, userDto);


        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, userRest);

        return userRest;
    }

    @GetMapping
    @RequestMapping(method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE,consumes = APPLICATION_JSON_VALUE)
    public String getUser(){
        return "get user";
    }




}
