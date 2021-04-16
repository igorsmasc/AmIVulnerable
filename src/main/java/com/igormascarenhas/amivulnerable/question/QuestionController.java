package com.igormascarenhas.amivulnerable.question;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Api(value = "REST API - QUESTION")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/questions")
    @ApiOperation(value = "GET ALL QUESTIONS")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PostMapping("/question")
    @ApiOperation(value = "REGISTER A NEW QUESTION")
    public void registerNewQuestion(@RequestBody Question question) {
        questionService.addNewQuestion(question);
    }

}
