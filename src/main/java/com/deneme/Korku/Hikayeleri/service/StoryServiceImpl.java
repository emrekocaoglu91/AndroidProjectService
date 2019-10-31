package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.model.Story;
import com.deneme.Korku.Hikayeleri.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryServiceImpl implements StoryService{

    @Autowired
    private StoryRepository storyRepository;


    @Override
    public Story save(Story story) {
        return storyRepository.save(story);
    }

    @Override
    public void delete(Story story) {
        storyRepository.delete(story);
    }

    @Override
    public Story getStory(Long id) {
        return storyRepository.getOne(id);
    }

    @Override
    public List<Story> getAllStories() {
        return storyRepository.findAllByIsActive('Y');
    }
}
