package com.xandy.workshopspringmongo.repository;


import com.xandy.workshopspringmongo.domains.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ 'title' :  { $regex: ?0, $options:  'i'} }")
    List<Post> searchByTitle(String title);

    List<Post> findByTitleContainingIgnoreCase(String title);

}
