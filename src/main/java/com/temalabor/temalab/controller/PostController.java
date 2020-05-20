package com.temalabor.temalab.controller;

import com.temalabor.temalab.model.Comment;
import com.temalabor.temalab.model.Post;
import com.temalabor.temalab.model.VoteRequest;
import com.temalabor.temalab.repository.CommentRepository;
import com.temalabor.temalab.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Post newPost(@RequestBody Post post){
        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUsername(details.getUsername());
        postRepository.save(post);
        return post;
    }
    @GetMapping()
    public List<Post> getPostsByCategory(@RequestParam(value = "category", required = false) String category){
        if(category != null) {
            return postRepository.findAllByCategoryName(category);
        }
        return postRepository.findAll();
    }
    @GetMapping(value = "/{id}")
    public Optional<Post> getPostsById(@PathVariable("id") String id) {
        return postRepository.findById(id);
    }
    @GetMapping(value = "/{id}/comments")
    public ResponseEntity<?> getComments(@PathVariable("id") String id){
        return ResponseEntity.ok(commentRepository.findAllByPostId(id));
    }
    @PostMapping(value = {"/{id}/comments"})
    public ResponseEntity<?> addNewComment(@PathVariable("id") String id, @RequestBody Comment comment){
        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setUsername(details.getUsername());
        comment.setPostId(id);
        Optional<Post> post = postRepository.findById(id);
        post.ifPresent(p -> p.getComments().add(comment));
        post.ifPresent(p -> postRepository.save(p));
        return ResponseEntity.ok(commentRepository.save(comment));
    }
    @DeleteMapping(value = "/{id}/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable("id") String id, @PathVariable("commentId") String commentId){
        commentRepository.deleteById(commentId);
        return ResponseEntity.ok("Comment with "+commentId+" has been deleted");
    }
    @PostMapping(value = "/{id}/vote")
    public void addVote(@PathVariable("id") String id,@RequestBody VoteRequest vote){
        Optional<Post> post = postRepository.findById(id);
        if (vote.getVote().equals("up")){
            post.ifPresent(p -> p.setUpVote(p.getUpVote()+1));
        }else if(vote.getVote().equals("down")) {
            post.ifPresent(p -> p.setDownVote(p.getDownVote()+1));
        }
        post.ifPresent(p -> postRepository.save(p));

    }

}
