package com.sideproject.learningtrack.restcontroller;

import com.sideproject.learningtrack.domain.Topic;
import com.sideproject.learningtrack.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping(value = "/all-topics", produces = "application/json")
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @PostMapping(value = "/add-topic", consumes = "application/json")
    public Topic addTopic(@RequestBody Topic topic) {
        return topicRepository.insert(topic);
    }

    @DeleteMapping(value = "/delete-goal/{topicId}")
    public void deleteTopic(@PathVariable String topicId) {
        topicRepository.deleteById(topicId);
    }

}
