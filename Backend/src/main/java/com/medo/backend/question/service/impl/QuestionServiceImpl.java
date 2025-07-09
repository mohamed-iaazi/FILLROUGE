package com.medo.backend.question.service.impl;

import com.medo.backend.question.dto.QuestionDTO;
import com.medo.backend.question.model.Question;
import com.medo.backend.question.repository.QuestionRepository;
import com.medo.backend.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public QuestionDTO createQuestion(QuestionDTO questionDTO) {
        Question question = Question.builder()
                .title(questionDTO.getTitle())
                .description(questionDTO.getDescription())
                .createdAt(questionDTO.getCreatedAt())
                .author(questionDTO.getAuthor())
                .answers(questionDTO.getAnswers())
                .build();
        Question saved = questionRepository.save(question);
        return toDTO(saved);
    }

    @Override
    public QuestionDTO updateQuestion(Long id, QuestionDTO questionDTO) {
        Optional<Question> optional = questionRepository.findById(id);
        if (optional.isEmpty()) return null;
        Question question = optional.get();
        question.setTitle(questionDTO.getTitle());
        question.setDescription(questionDTO.getDescription());
        Question updated = questionRepository.save(question);
        return toDTO(updated);
    }

    @Override
    public boolean deleteQuestion(Long id) {
        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public QuestionDTO getQuestion(Long id) {
        return questionRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<QuestionDTO> getAllQuestions() {
        return ((List<Question>) questionRepository.findAll())
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    private QuestionDTO toDTO(Question question) {
        return QuestionDTO.builder()
                .id(question.getId())
                .title(question.getTitle())
                .description(question.getDescription())
                .createdAt(question.getCreatedAt())
                .author(question.getAuthor())
                .answers(question.getAnswers())
                .build();
    }
} 