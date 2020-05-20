package com.temalabor.temalab.repository;

import com.temalabor.temalab.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

     List<Post> findAllByUsername(String username);
     List<Post> findAllByCategoryName(String category);
}
