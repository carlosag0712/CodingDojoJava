package io.carlosarosemena.grouplanguages.Controllers;


import io.carlosarosemena.grouplanguages.models.language;
import io.carlosarosemena.grouplanguages.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Main {

    @Autowired
    private LanguageService languageService;

    @RequestMapping("/")
    public String index(Model model){
        ArrayList<language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "index";
    }
}
