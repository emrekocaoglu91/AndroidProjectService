package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.entity.CommentEntity;
import com.deneme.Korku.Hikayeleri.repository.CommentRepository;
import com.deneme.Korku.Hikayeleri.shared.dto.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        commentEntity.setStoryID(storyID);
        commentEntity.setUserName(userName);
        CommentEntity storedComment = commentRepository.save(commentEntity);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(storedComment, CommentDto.class);

        return commentDto;
    }

    @Override
    public List<CommentEntity> getStoryComments(Long storyID,Character character) {
        List<CommentEntity> commentEntityList = commentRepository.getAllCommentsByStoryIDAndAndIsActive(storyID,character);
        return  commentEntityList;
    }

    @Override
    public void deleteComment(Long commentId) {
        CommentEntity commentEntity= commentRepository.getOne(commentId);
        commentEntity.setIsActive('N');
        commentRepository.save(commentEntity);
    }
}
