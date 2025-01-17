package com.xandy.workshopspringmongo.services;

import com.xandy.workshopspringmongo.domains.Post;
import com.xandy.workshopspringmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServices {

    @Autowired
    private PostRepository repository;


    public Post findById(String id) {
        Post post = repository.findById(id).orElse(null);
        return post;
    }
}
