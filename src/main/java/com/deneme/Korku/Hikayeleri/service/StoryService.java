package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.model.Story;

import java.util.List;
import java.util.Optional;

public interface StoryService {

    List<Story> getAllStories();

    Optional<Story> findStoryById(Long id);
}
