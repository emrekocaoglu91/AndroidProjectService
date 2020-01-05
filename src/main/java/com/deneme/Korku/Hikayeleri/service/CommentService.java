package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.shared.dto.CommentDto;
import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;

public interface CommentService {

     CommentDto createComment(CommentDto commentDto,String userID, Long storyID);

}
