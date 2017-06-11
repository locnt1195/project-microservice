package com.doj.upload.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVideoRepository extends MongoRepository<Video, String>{

}
