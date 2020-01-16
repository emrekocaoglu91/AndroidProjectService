package com.deneme.Korku.Hikayeleri.controller;

import com.deneme.Korku.Hikayeleri.entity.StoryEntity;
import com.deneme.Korku.Hikayeleri.entity.UserEntity;
import com.deneme.Korku.Hikayeleri.exception.UserServiceException;
import com.deneme.Korku.Hikayeleri.model.request.CommentRequestModel;
import com.deneme.Korku.Hikayeleri.model.response.CommentRest;
import com.deneme.Korku.Hikayeleri.model.response.ErrorMessages;
import com.deneme.Korku.Hikayeleri.repository.CommentRepository;
import com.deneme.Korku.Hikayeleri.repository.UserRepository;
import com.deneme.Korku.Hikayeleri.service.CommentService;
import com.deneme.Korku.Hikayeleri.shared.dto.CommentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/comments")
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    @RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public CommentRest createComment(@RequestBody CommentRequestModel commentRequestModel, HttpServletRequest httpServletRequest, Long storyID) {

        String userName = httpServletRequest.getUserPrincipal().getName();

        UserEntity userEntity;

        if (userRepository.findByUserName(userName) != null) {
            userEntity = userRepository.findByUserName(userName);
        } else {
            throw new UserServiceException(ErrorMessages.AUTHENTICATION_FAILED.getErrorMessage());
        }


        CommentRest commentRest = new CommentRest();
        CommentDto commentDto= new CommentDto();

        BeanUtils.copyProperties(commentRequestModel,commentDto);

        StoryEntity storyEntity = new StoryEntity();
        storyEntity.setId(storyID);
        CommentDto commentDtoStored = commentService.createComment(commentDto,userEntity.getUserId(), storyID);
        BeanUtils.copyProperties(commentDtoStored, commentRest);
       /* System.out.println(commentRest.getUserName());
        System.out.println(commentRest.getCommentText());
        System.out.println(commentRest.getStoryID());
        System.out.println(userEntity.getUserId());*/

        return commentRest;
    }


}
