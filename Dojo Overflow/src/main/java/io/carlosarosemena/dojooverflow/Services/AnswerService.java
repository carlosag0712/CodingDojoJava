package io.carlosarosemena.dojooverflow.Services;

import io.carlosarosemena.dojooverflow.Models.Answers;
import io.carlosarosemena.dojooverflow.Repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionService questionService;

    public Answers createAnswer(String answer, Long id){
        Answers newanswer = new Answers();
        newanswer.setAnswer(answer);
        newanswer.setQuestion(questionService.findOne(id));
        return answerRepository.save(newanswer);

    }


}
