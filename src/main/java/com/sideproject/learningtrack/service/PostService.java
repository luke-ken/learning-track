package com.sideproject.learningtrack.service;

import com.sideproject.learningtrack.domain.Post;

import com.sideproject.learningtrack.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final TagService tagService;

    @Autowired
    public PostService(PostRepository postRepository, TagService tagService) {
        this.postRepository = postRepository;
        this.tagService = tagService;
    }

    // todo: better naming in combination with the method in the 'PostController'
    public Post onCreateNewPost(Post post) {
        System.out.println(post.toString());

        tagService.checkForNewTagToUpdate(post.getTags());

        return postRepository.insert(post);
    }

    public Post onUpdatePost(Post updatedPost) {
        System.out.println(updatedPost.toString());

        tagService.checkForNewTagToUpdate(updatedPost.getTags());

        return postRepository.save(updatedPost);
    }

}
