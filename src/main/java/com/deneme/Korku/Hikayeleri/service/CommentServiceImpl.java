package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.entity.CommentEntity;
import com.deneme.Korku.Hikayeleri.model.response.CommentRest;
import com.deneme.Korku.Hikayeleri.repository.CommentRepository;
import com.deneme.Korku.Hikayeleri.shared.dto.CommentDto;
import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public CommentDto createComment(CommentDto commentDto,String userID, Long storyID,String userName) {

        CommentEntity commentEntity = new CommentEntity();


        commentEntity.setUserID(userID);
        commentEntity.setCommentText(commentDto.getCommentText());
        commentEntity.setStoryID(1L);
        commentEntity.setUserName(userName);
        CommentEntity storedComment = commentRepository.save(commentEntity);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(storedComment, CommentDto.class);


        return commentDto;
    }

    @Override
    public List<CommentEntity> getStoryComments(Long storyID) {
        List<CommentEntity> commentEntityList = commentRepository.getAllCommentsByStoryID(storyID);
        return  commentEntityList;
    }
}
