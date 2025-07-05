package com.medo.backend.question.repository;

import com.medo.backend.question.model.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {
    // Add custom query methods if needed
} 