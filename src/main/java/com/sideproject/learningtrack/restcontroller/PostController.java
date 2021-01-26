package com.sideproject.learningtrack.restcontroller;

import com.sideproject.learningtrack.domain.Post;
import com.sideproject.learningtrack.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping(value = "/all-posts", produces = "application/json")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping(value = "/posts/{topic}")
    public List<Post> getPostsOfOneTopic(@PathVariable String topic) {
        return postRepository.findAllByTopic(topic);
    }

    @GetMapping(value = "/post/{id}")
    public Optional<Post> getPost(@PathVariable String id) {
        return postRepository.findById(id);
    }

    @PostMapping(value = "/add-post", consumes = "application/json")
    public Post addPost(@RequestBody Post post) {
        return postRepository.insert(post);
    }

    @DeleteMapping(value = "/delete-post/{id}")
    public void deletePost(@PathVariable String id) {
        postRepository.deleteById(id);
    }
}
