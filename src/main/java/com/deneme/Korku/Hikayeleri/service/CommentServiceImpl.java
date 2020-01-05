package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.entity.CommentEntity;
import com.deneme.Korku.Hikayeleri.repository.CommentRepository;
import com.deneme.Korku.Hikayeleri.shared.dto.CommentDto;
import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public CommentDto createComment(CommentDto commentDto,String userID, Long storyID) {

        CommentEntity commentEntity = new CommentEntity();


        commentEntity.setUserID(userID);
        commentEntity.setCommentText(commentDto.getCommentText());
        commentEntity.setStoryID(1L);
        CommentEntity storedComment = commentRepository.save(commentEntity);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(storedComment, CommentDto.class);


        return commentDto;
    }
}
