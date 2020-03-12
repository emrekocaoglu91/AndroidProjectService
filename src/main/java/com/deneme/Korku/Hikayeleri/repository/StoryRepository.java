package com.deneme.Korku.Hikayeleri.repository;

import com.deneme.Korku.Hikayeleri.entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoryRepository extends JpaRepository<StoryEntity, Long> {

    List<StoryEntity> getAllByIsActive(Character character);
    Optional<StoryEntity> findStoryByIdAndIsActive(Long storyID, Character character);
}
