package com.temalabor.temalab.controller;

import com.temalabor.temalab.model.Post;
import com.temalabor.temalab.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Post newPost(@RequestBody Post post){

        postRepository.save(post);
        return post;
    }

    @GetMapping(value = "/{username}")
    public List<Post> getPostsByID(@PathVariable("username") String username){
        return postRepository.findAllByUsername(username);
    }

    @GetMapping()
    public List<Post> getPostsByCategory(@RequestParam(value = "category", required = false) String category){
        if(category != null) {
            return postRepository.findAllByCategoryName(category);
        }
        return postRepository.findAll();
    }
}
