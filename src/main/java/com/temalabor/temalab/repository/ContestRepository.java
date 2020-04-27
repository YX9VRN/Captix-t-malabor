package com.temalabor.temalab.repository;

import com.temalabor.temalab.model.Contest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContestRepository extends MongoRepository<Contest, String> {

}
