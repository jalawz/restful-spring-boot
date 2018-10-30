package com.in28minutes.rest.webservices.daos;

import com.in28minutes.rest.webservices.domain.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PostDaoService {

    private static int postsCount = 2;

    private static List<Post> posts = new ArrayList<>();

    static {
        posts.add(new Post(1, "Test Post", "Lorem ipsum sit dolor amet"));
        posts.add(new Post(2, "Second Post", "Just a text for a simple test post"));
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post findOnde(int id) {
        Post post = posts.stream().filter(postToFilter -> postToFilter.getId() == id).findFirst().orElse(null);
        return (post != null) ? post : null;
    }

    public Post save(Post post) {
        if(post.getId() == null) {
            post.setId(++postsCount);
        }
        posts.add(post);
        return post;
    }
}
