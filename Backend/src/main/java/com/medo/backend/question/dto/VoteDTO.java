package com.medo.backend.question.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoteDTO {
    private Long id;
    private Long userId;
    private Long questionId;
    private Long answerId;
    private boolean upvote;
} 