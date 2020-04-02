package com.deneme.Korku.Hikayeleri.repository;

import com.deneme.Korku.Hikayeleri.entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoryRepository extends JpaRepository<StoryEntity, Long> {

    @Query(value = "select * from story s where s.is_active='Y' order by s.id desc " ,nativeQuery = true)
    List<StoryEntity> getAllByIsActive(String character);

    Optional<StoryEntity> findStoryByIdAndIsActive(Long storyID, String character);
}
