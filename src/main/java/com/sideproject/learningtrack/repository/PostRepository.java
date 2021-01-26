package com.sideproject.learningtrack.repository;

import com.sideproject.learningtrack.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findAllByTopic(String topic);
}
