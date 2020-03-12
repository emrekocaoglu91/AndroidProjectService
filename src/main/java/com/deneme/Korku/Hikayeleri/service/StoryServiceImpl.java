package com.deneme.Korku.Hikayeleri.service;

import com.deneme.Korku.Hikayeleri.entity.StoryEntity;
import com.deneme.Korku.Hikayeleri.entity.UserStoryEntity;
import com.deneme.Korku.Hikayeleri.model.request.UserStoryRequestModel;
import com.deneme.Korku.Hikayeleri.repository.StoryRepository;
import com.deneme.Korku.Hikayeleri.repository.UserStoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoryServiceImpl implements StoryService {

    @Autowired
    StoryRepository storyRepository;

    @Autowired
    UserStoryRepository userStoryRepository;

    @Override
    public List<StoryEntity> getAllStories() {
        return storyRepository.getAllByIsActive('Y');
    }

    @Override
    public Optional<StoryEntity> findStoryById(Long id) {
        return storyRepository.findStoryByIdAndIsActive(id,'Y');
    }

    @Override
    public StoryEntity saveStory(StoryEntity storyEntity) {
        return storyRepository.save(storyEntity);
    }

    @Override
    public UserStoryEntity saveUserStory(UserStoryRequestModel userStoryRequestModel) {
        UserStoryEntity userStoryEntity = new UserStoryEntity();
        BeanUtils.copyProperties(userStoryRequestModel,userStoryEntity);
        return userStoryRepository.save(userStoryEntity);
    }
}
