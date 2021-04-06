package com.sideproject.learningtrack.controller;

import com.sideproject.learningtrack.domain.Tag;
import com.sideproject.learningtrack.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    private final TagRepository tagRepository;

    @Autowired
    public TagController(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @GetMapping(value = "/all-tags", produces = "application/json")
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

//    @PostMapping(value = "/add-tag", consumes = "application/json")
//    public Tag addTag(@RequestBody Tag tag) {
//        return tagRepository.insert(tag);
//    }
//
//    @DeleteMapping(value = "/delete-tag/{tagId}")
//    public void deleteTag(@PathVariable String tagId) {
//        tagRepository.deleteById(tagId);
//    }

}
