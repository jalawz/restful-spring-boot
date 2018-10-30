package com.in28minutes.rest.webservices.controllers;

import com.in28minutes.rest.webservices.controllers.exceptions.PostNotFoundException;
import com.in28minutes.rest.webservices.daos.PostDaoService;
import com.in28minutes.rest.webservices.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class PostResource {

    @Autowired
    private PostDaoService service;

    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllPosts() {
        return service.findAll();
    }

    @GetMapping("/users/{id}/posts/{postId}")
    public Post retrievePost(@PathVariable int postId) {
        Post post = service.findOnde(postId);
        if (post == null) {
            throw new PostNotFoundException("Id: " + postId);
        }
        return post;
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<?> savePost(@RequestBody Post post) {
        Post savedPost = service.save(post);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{postId}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
