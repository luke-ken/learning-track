package com.sideproject.learningtrack.repository;

import com.sideproject.learningtrack.domain.Goal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GoalRepository extends MongoRepository<Goal, String> {

    void deleteByName(String name);
}
