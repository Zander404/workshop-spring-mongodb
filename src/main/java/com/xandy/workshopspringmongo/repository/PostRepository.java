package com.xandy.workshopspringmongo.repository;


import com.xandy.workshopspringmongo.domains.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
