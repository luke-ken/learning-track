package com.sideproject.learningtrack.repository;

import com.sideproject.learningtrack.domain.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TagRepository extends MongoRepository<Tag, String> {

    void deleteByName(String name);

    List<Tag> findByName(String name);

    boolean existsByName(String name);
}
