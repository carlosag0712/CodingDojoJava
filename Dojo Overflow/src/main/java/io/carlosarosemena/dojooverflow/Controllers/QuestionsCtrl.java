package io.carlosarosemena.dojooverflow.Controllers;


import io.carlosarosemena.dojooverflow.Models.Answers;
import io.carlosarosemena.dojooverflow.Models.Questions;
import io.carlosarosemena.dojooverflow.Models.Tags;
import io.carlosarosemena.dojooverflow.Services.AnswerService;
import io.carlosarosemena.dojooverflow.Services.QuestionService;
import io.carlosarosemena.dojooverflow.Services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionsCtrl {

    @Autowired
    private TagService tagService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @RequestMapping()
    public String questions(Model model){
        model.addAttribute("questions", questionService.findAll());

        return "index";
    }

    @RequestMapping("/new")
    public String questionForm(){
        return "newquestion";
    }

    @PostMapping("/post")
    public String postQuestion(@RequestParam("question")String question, @RequestParam("tags")String tags, RedirectAttributes redirectAttributes){

        List<Tags> questionTags = tagService.FindOrCreateTags(tags);


        try{
            questionService.createQuestion(question, questionTags);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errors","Question cannot be empty, 3 Tags Max!");
            return "redirect:/questions/new";
        }


        return "redirect:/questions";
    }

    @RequestMapping("/{id}")
    public String answerForm(@PathVariable("id")Long id, Model model){
        Questions question = questionService.findOne(id);
        model.addAttribute("question", question);
        model.addAttribute("answers", question.getAnswers());

        return "showquestion";


    }

    @PostMapping("/newanswer")
    public String postAnswer(@RequestParam("answer")String answer,@RequestParam("questionId")Long id,  RedirectAttributes redirectAttributes){

        try{
            Answers newanswer = answerService.createAnswer(answer, id);
//            questionService.addAnswer(id,newanswer);
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("errors","Cannot submit an empty answer");
            return "redirect:/questions/"+id;
        }

        return "redirect:/questions/"+id;


    }



}
