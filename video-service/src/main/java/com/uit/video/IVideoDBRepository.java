package com.uit.video;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IVideoDBRepository extends MongoRepository<VideoDB, String>{

}
