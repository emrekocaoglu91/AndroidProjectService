package com.deneme.Korku.Hikayeleri.controller;

import com.deneme.Korku.Hikayeleri.entity.StoryEntity;
import com.deneme.Korku.Hikayeleri.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/story")
@Controller
public class StoryController {

    @Autowired
    StoryService storyService;

    @GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseEntity<List<StoryEntity>> getAllStories() {
        return new ResponseEntity<>(storyService.getAllStories(), HttpStatus.OK);
    }

    @GetMapping(path = "/getStory/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<StoryEntity> getStory(@PathVariable String id) {
        Long storyId = Long.parseLong(id);
        Optional<StoryEntity> story = storyService.findStoryById(storyId);
        return story.map(story1 -> new ResponseEntity<>(story1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

    @PostMapping(path = "/postStory", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<StoryEntity> postStory(@RequestBody StoryEntity storyEntity) {
        try {
            StoryEntity story = storyService.saveStory(storyEntity);
            return new ResponseEntity<>(story, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }


}
