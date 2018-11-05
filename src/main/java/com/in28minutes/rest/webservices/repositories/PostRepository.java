package com.in28minutes.rest.webservices.repositories;

import com.in28minutes.rest.webservices.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
