package com.deneme.Korku.Hikayeleri.controller;

import com.deneme.Korku.Hikayeleri.model.response.StoryRest;
import com.deneme.Korku.Hikayeleri.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@RequestMapping("/story")
@Controller
public class StoryController {

    @Autowired
    StoryService storyService;

    @GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public ResponseEntity<List<StoryRest>> getAllStories() {
        return new ResponseEntity<>(storyService.getAllStories(), HttpStatus.OK);
    }

    @GetMapping(path = "/getStory/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<StoryRest> getStory(@PathVariable String id) {
        Long storyId = Long.parseLong(id);
        Optional<StoryRest> story = storyService.findStoryById(storyId);
        return story.map(storyRest1 -> new ResponseEntity<>(storyRest1, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

}
