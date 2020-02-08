package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.entity.CommentEntity;
import com.deneme.Korku.Hikayeleri.shared.dto.CommentDto;

import java.util.List;

public interface CommentService {

     CommentDto createComment(CommentDto commentDto,String userID, Long storyID,String userName);

     List<CommentEntity> getStoryComments(Long storyID);

}
