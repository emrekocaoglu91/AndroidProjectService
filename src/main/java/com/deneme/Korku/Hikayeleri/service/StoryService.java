package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.model.response.StoryRest;

import java.util.List;
import java.util.Optional;

public interface StoryService {

    List<StoryRest> getAllStories();

    Optional<StoryRest> findStoryById(Long id);
}
