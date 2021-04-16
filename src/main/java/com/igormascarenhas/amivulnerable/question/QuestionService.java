package com.igormascarenhas.amivulnerable.question;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public void addNewQuestion(Question question) {
        Optional<Question> questionOptional = questionRepository
                .findQuestionByTitle(question.getTitle());
        if(questionOptional.isPresent()) {
            throw new IllegalStateException("This question already exists.");
        }
    }

}
