package com.xandy.workshopspringmongo.resources;

import com.xandy.workshopspringmongo.domains.Post;
import com.xandy.workshopspringmongo.repository.PostRepository;
import com.xandy.workshopspringmongo.resources.utils.URL;
import com.xandy.workshopspringmongo.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

    @Autowired
    private PostServices service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findBy(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParams(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
