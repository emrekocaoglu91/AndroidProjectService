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
        commentEntity.setIsActive("Y");
        commentEntity.setDeleted(false);
        CommentEntity storedComment = commentRepository.save(commentEntity);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(storedComment, CommentDto.class);

        return commentDto;
    }

    @Override
    public List<CommentEntity> getStoryComments(Long storyID) {
        List<CommentEntity> commentEntityList = commentRepository.getUserCommentsByStoryIDAndIsActiveAndDeleted(storyID);
        return  commentEntityList;
    }

    @Override
    public void deleteComment(Long commentId) {
        CommentEntity commentEntity= commentRepository.getOne(commentId);
        commentEntity.setDeleted(true);
        commentRepository.save(commentEntity);
    }

    @Override
    public List<CommentEntity> getCommentsByUserId(String userID) {
        List<CommentEntity> commentEntityList = commentRepository.getAllByUserID(userID);
        return commentEntityList;
    }


    public List<CommentEntity> setDeletedUserCommentToPassive(String userId){
        List<CommentEntity> commentEntityList = commentRepository.getAllByUserID(userId);
        for (CommentEntity comment : commentEntityList){
            comment.setIsActive("N");
        }

        return commentRepository.saveAll(commentEntityList);
    }

    @Override
    public List<CommentEntity> setReactiveUserCommentToActive(String userId) {
        List<CommentEntity> commentEntityList = commentRepository.getAllByUserID(userId);
        for (CommentEntity comment : commentEntityList){
            comment.setIsActive("Y");
        }

        return commentRepository.saveAll(commentEntityList);
    }

}
