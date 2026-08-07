package com.alechimello.workshopmongo.repositories;

import com.alechimello.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
