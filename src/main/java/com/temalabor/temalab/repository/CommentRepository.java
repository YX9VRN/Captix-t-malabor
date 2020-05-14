package com.temalabor.temalab.repository;

import com.temalabor.temalab.model.Comment;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<Comment,String > {
    List<Comment> findAllByPostId(String postId);
}
