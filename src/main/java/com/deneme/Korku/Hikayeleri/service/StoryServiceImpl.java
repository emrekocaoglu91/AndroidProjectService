package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.entity.StoryEntity;
import com.deneme.Korku.Hikayeleri.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    StoryRepository storyRepository;

    @Override
    public List<StoryEntity> getAllStories() {
        return storyRepository.findAll();
    }

    @Override
    public Optional<StoryEntity> findStoryById(Long id) {
        return storyRepository.findById(id);
    }

    @Override
    public StoryEntity saveStory(StoryEntity storyEntity) {
        return storyRepository.save(storyEntity);
    }
}
