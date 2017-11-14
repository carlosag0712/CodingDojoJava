package io.carlosarosemena.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/projects")
    public String projects(){
        return "projects";
    }

    @RequestMapping("/me")
    public String aboutme(){
        return "about";
    }
}
