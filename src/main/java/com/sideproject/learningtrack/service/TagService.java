package com.sideproject.learningtrack.service;

import com.sideproject.learningtrack.domain.Tag;
import com.sideproject.learningtrack.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public void checkForNewTagToUpdate(String[] tagsArray) {
        for (String tagName: tagsArray) {
            if (!tagRepository.existsByName(tagName)) {
                tagRepository.insert(new Tag(tagName, ""));
            }
        }
    }
}
