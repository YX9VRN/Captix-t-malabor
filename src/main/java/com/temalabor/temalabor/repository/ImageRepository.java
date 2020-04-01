package com.temalabor.temalabor.repository;

import com.temalabor.temalabor.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {

}
