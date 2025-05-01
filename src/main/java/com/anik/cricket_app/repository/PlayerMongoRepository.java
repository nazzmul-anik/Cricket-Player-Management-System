package com.anik.cricket_app.repository;

import com.anik.cricket_app.entity.PlayerEntity;
import com.anik.cricket_app.entity.PlayerMongoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerMongoRepository extends MongoRepository<PlayerMongoEntity, Integer> {
    List<PlayerMongoEntity> findAllByRole(String role);

}
