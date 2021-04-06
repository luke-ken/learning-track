package com.sideproject.learningtrack.controller;

import com.sideproject.learningtrack.domain.Post;
import com.sideproject.learningtrack.dto.ImageInfo;
import com.sideproject.learningtrack.dto.PostContentExclude;
import com.sideproject.learningtrack.repository.PostRepository;
import com.sideproject.learningtrack.service.PostService;
import com.sideproject.learningtrack.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;
    private final TagService tagService;

    @Autowired
    public PostController(PostService postService, TagService tagService, PostRepository postRepository) {
        this.postService = postService;
        this.tagService = tagService;
        this.postRepository = postRepository;
    }

    @GetMapping(value = "/all-posts", produces = "application/json")
    public List<PostContentExclude> getAllPosts() {
        return postRepository.findByIdIsNotNull();
    }

    @GetMapping(value = "/single-post/{id}")
    public Optional<Post> getPost(@PathVariable String id) {
        return postRepository.findById(id);
    }

    @PostMapping(value = "/add-post", consumes = "application/json")
    public Post handleNewPostCreation(@RequestBody Post post) {
        return postService.onCreateNewPost(post);
    }

    @PutMapping(value = "/update-post", consumes = "application/json")
    public ResponseEntity<ImageInfo> updatePost(@RequestBody Post updatedPost) {
        postService.onUpdatePost(updatedPost);
        // todo: return a response with only header, no body?
        return ResponseEntity.ok().body(new ImageInfo("ok"));
    }

    @DeleteMapping(value = "/delete-post/{id}")
    public void deletePost(@PathVariable String id) {
        postRepository.deleteById(id);
    }

}
