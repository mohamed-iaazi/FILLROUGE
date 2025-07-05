package com.medo.backend.question.service;

import com.medo.backend.question.dto.LikeDTO;

public interface LikeService {
    LikeDTO likeComment(Long commentId, Long userId);
    boolean unlikeComment(Long commentId, Long userId);
} 