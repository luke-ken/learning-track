package com.sideproject.learningtrack.repository;

import com.sideproject.learningtrack.domain.GoalProgress;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalProgressRepository extends MongoRepository<GoalProgress, String> {

    List<GoalProgress> findAllByName(String name);
}
