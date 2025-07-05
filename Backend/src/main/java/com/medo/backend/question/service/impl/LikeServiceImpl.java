package com.medo.backend.question.service.impl;

import com.medo.backend.question.dto.LikeDTO;
import com.medo.backend.question.model.Comment;
import com.medo.backend.question.model.Like;
import com.medo.backend.question.repository.CommentRepository;
import com.medo.backend.question.repository.LikeRepository;
import com.medo.backend.question.service.LikeService;
import com.medo.backend.user.model.User;
import com.medo.backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository, CommentRepository commentRepository, UserRepository userRepository) {
        this.likeRepository = likeRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public LikeDTO likeComment(Long commentId, Long userId) {
        Optional<Comment> commentOpt = commentRepository.findById(commentId);
        Optional<User> userOpt = userRepository.findById(userId);
        if (commentOpt.isEmpty() || userOpt.isEmpty()) return null;
        Comment comment = commentOpt.get();
        User user = userOpt.get();
        // Check if already liked
        for (Like like : comment.getLikes()) {
            if (like.getUser().getUserId().equals(userId)) {
                return toDTO(like);
            }
        }
        Like like = Like.builder().user(user).comment(comment).build();
        Like saved = likeRepository.save(like);
        return toDTO(saved);
    }

    @Override
    public boolean unlikeComment(Long commentId, Long userId) {
        Optional<Comment> commentOpt = commentRepository.findById(commentId);
        if (commentOpt.isEmpty()) return false;
        Comment comment = commentOpt.get();
        for (Like like : comment.getLikes()) {
            if (like.getUser().getUserId().equals(userId)) {
                likeRepository.deleteById(like.getId());
                return true;
            }
        }
        return false;
    }

    private LikeDTO toDTO(Like like) {
        return LikeDTO.builder()
                .id(like.getId())
                .userId(like.getUser().getUserId())
                .commentId(like.getComment().getId())
                .build();
    }
} 