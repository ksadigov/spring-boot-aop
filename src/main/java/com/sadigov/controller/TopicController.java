package com.sadigov.controller;

import com.sadigov.model.Topic;
import com.sadigov.service.TopicService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {


    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @PostMapping
    public void createTopic(@RequestBody Topic topic) {
        topicService.createTopic(topic);
    }

    @PutMapping("{id}")
    public void updateTopic(@PathVariable String id,
                            @RequestBody Topic topic) {
        topicService.updateTopic(id, topic);
    }

    @DeleteMapping("{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}

