package com.medo.backend.question.controller;

import com.medo.backend.question.dto.LikeDTO;
import com.medo.backend.question.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {
    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/comment/{commentId}/user/{userId}")
    public ResponseEntity<LikeDTO> likeComment(@PathVariable Long commentId, @PathVariable Long userId) {
        return ResponseEntity.ok(likeService.likeComment(commentId, userId));
    }

    @DeleteMapping("/comment/{commentId}/user/{userId}")
    public ResponseEntity<Void> unlikeComment(@PathVariable Long commentId, @PathVariable Long userId) {
        likeService.unlikeComment(commentId, userId);
        return ResponseEntity.noContent().build();
    }
} 