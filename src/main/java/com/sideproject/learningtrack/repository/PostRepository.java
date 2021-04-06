package com.sideproject.learningtrack.repository;

import com.sideproject.learningtrack.domain.Post;
import com.sideproject.learningtrack.dto.PostContentExclude;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query(value = "{}", sort = "{timestamp: -1}")
    List<PostContentExclude> findByIdIsNotNull();

}
