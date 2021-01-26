package com.sideproject.learningtrack.repository;

import com.sideproject.learningtrack.domain.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TopicRepository extends MongoRepository<Topic, String> {

    void deleteByName(String name);
}
