package com.deneme.Korku.Hikayeleri.repository;

import com.deneme.Korku.Hikayeleri.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

    List<CommentEntity> getAllCommentsByStoryIDAndAndIsActive(Long StoryID,String character);

    List<CommentEntity> getAllByUserID(String userId);


    @Query(value = "select * FROM comments c where c.comment_story_id =:storyID and c.is_active='Y' and c.comment_is_deleted=false ",
            nativeQuery = true)
    List<CommentEntity> getUserCommentsByStoryIDAndIsActiveAndDeleted(@Param("storyID") Long StoryID);

}
