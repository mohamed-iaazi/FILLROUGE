package com.medo.backend.question.repository;

import com.medo.backend.question.model.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {
    // Add custom query methods if needed
} 