package com.sadigov.service;

import com.sadigov.aspects.Timed;
import com.sadigov.model.Topic;
import com.sadigov.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Timed
    public List<Topic> getAllTopics() {
        List<Topic> topicList = new ArrayList<>();
        topicRepository.findAll().forEach(topicList::add);
        return topicList;
    }

    public Topic getTopic(String id) {
        return topicRepository.findById(id).get();
    }

    public void createTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
