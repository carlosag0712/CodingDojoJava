package io.carlosarosemena.grouplanguages.Controllers;


import com.sun.tools.internal.xjc.Language;
import io.carlosarosemena.grouplanguages.models.language;
import io.carlosarosemena.grouplanguages.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Main {

    @Autowired
    private LanguageService languageService;

    //

    @RequestMapping("/")
    public String index(@ModelAttribute("language") language language, Model model){
        model.addAttribute("languages", languageService.allLanguages());
        return "index";
    }

    @PostMapping("/languages")
    public String createLanguages(@Valid @ModelAttribute("language") language language, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("languages", languageService.allLanguages());
            return "index";
        }else{
            languageService.addLanguage(language);
            return "redirect:/";
        }

    }

    @RequestMapping("/languages/{id}")
    public String showLanguage(Model model, @PathVariable("id") Long id){
        language language = languageService.findOne(id);
        model.addAttribute("id", id);
        model.addAttribute("language", language);

        return "show";
    }

    @RequestMapping("/languages/edit/{id}")
    public String editLanguage(Model model, @PathVariable("id") Long id){
        language language = languageService.findOne(id);
        model.addAttribute("id", id);
        model.addAttribute("language", language);

        return "edit";
    }

    @PostMapping("/languages/update/{id}")
    public String updateLanguage(@Valid @ModelAttribute("language") language language, BindingResult result, @PathVariable("id") Long id){
        if(result.hasErrors()){
            return "edit";
        }else{
            languageService.updateLanguage(id, language);
            return "redirect:/";
        }
    }

    @RequestMapping("/languages/delete/{id}")
    public String deleteLanguage(@PathVariable("id") Long id){
        languageService.deleteLanguage(id);

        return "redirect:/";
    }



}
