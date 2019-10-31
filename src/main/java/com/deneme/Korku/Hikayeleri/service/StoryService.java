package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.model.Story;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StoryService {

    public Story save(Story story);

    public void delete(Story story);

    public Story getStory(Long id);

    public List<Story> getAllStories();


}
