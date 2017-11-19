package io.carlosarosemena.learningplatform.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/m/{chapter}/0483/{assignment}")
    public String assignment(@PathVariable("assignment")String number, Model model){
        String goal;

        if(number.equals("0345")){
            goal = "The goal of the assignment is to create forms";
        }else{
            goal = "The goal of this is to learn fortran to binary";
        }

        model.addAttribute("goal",goal);
        return "assignment";
    }

    @RequestMapping("/m/{chapter}/0553/{lesson}")
    public String lesson(@PathVariable("lesson") String lesson, Model model){

        String goal;

        if(lesson.equals("0733")){
            goal = "Setting up your servers";
        }else if (lesson.equals("0342")){
            goal = "Punch Cards";
        }else{
            goal = "Advanced Fortran Intro";
        }

        model.addAttribute("goal",goal);
        return "lesson";
    }
}
