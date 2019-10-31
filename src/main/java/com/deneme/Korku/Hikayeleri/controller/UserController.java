package com.deneme.Korku.Hikayeleri.controller;

import com.deneme.Korku.Hikayeleri.model.User;
import com.deneme.Korku.Hikayeleri.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@Controller
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/get/{id}",produces = "application/json",headers = HttpHeaders.ACCEPT)
    @GetMapping
    public ResponseEntity<User>getUser(@PathVariable Long id){
        try {
            return new ResponseEntity(userService.getUser(id), HttpStatus.OK);

        }catch (Exception e){
            e.getStackTrace();
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


}
