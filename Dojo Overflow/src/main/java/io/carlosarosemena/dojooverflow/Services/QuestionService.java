package io.carlosarosemena.dojooverflow.Services;

import io.carlosarosemena.dojooverflow.Models.Answers;
import io.carlosarosemena.dojooverflow.Models.Questions;
import io.carlosarosemena.dojooverflow.Models.Tags;
import io.carlosarosemena.dojooverflow.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository  questionRepository;

    public List<Questions> findAll(){
        return questionRepository.findAll();
    }


    public Questions createQuestion(String question, List<Tags> tagsList){
        Questions newquestion = new Questions();

        newquestion.setQuestion(question);
        newquestion.setTags(tagsList);

        return questionRepository.save(newquestion);

    }

    public Questions findOne(Long id){
        Questions question = questionRepository.findOne(id);
        return question;

    }

//    public void addAnswer(Long id, Answers answers){
//        Questions question = questionRepository.findOne(id);
//        question.getAnswers().add(answers);
//        questionRepository.save(question);
//
//    }
}
