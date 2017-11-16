package io.carlosarosemena.dojosurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Main {



    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(
            @RequestParam("name") String name,
            @RequestParam("dojolocation") String dojolocation,
            @RequestParam("favouriteLang") String favouriteLang,
            @RequestParam(value = "comment", required = false) String comment,
            Model model
    ){

        model.addAttribute("name", name);
        model.addAttribute("location", dojolocation);
        model.addAttribute("language", favouriteLang);
        model.addAttribute("comment", comment);

        return "result";
    }
}
