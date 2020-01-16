package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.entity.StoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StoryService {

    List<StoryEntity> getAllStories();

    Optional<StoryEntity> findStoryById(Long id);

    StoryEntity saveStory(StoryEntity storyEntity);

}
