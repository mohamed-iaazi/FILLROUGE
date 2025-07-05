package com.medo.backend.question.repository;

import com.medo.backend.question.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    // Add custom query methods if needed
} 