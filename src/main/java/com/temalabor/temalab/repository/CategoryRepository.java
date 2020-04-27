package com.temalabor.temalab.repository;

import com.temalabor.temalab.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
