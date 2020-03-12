package com.deneme.Korku.Hikayeleri.repository;

import com.deneme.Korku.Hikayeleri.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

    List<CommentEntity> getAllCommentsByStoryIDAndAndIsActive(Long StoryID,Character character);




}
