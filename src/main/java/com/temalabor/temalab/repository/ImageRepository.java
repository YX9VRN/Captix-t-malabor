package com.temalabor.temalab.repository;

import com.temalabor.temalab.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {

}
