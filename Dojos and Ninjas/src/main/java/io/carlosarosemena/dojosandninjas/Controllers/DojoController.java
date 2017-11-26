package io.carlosarosemena.dojosandninjas.Controllers;

import io.carlosarosemena.dojosandninjas.Models.Dojo;
import io.carlosarosemena.dojosandninjas.Services.DojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/dojos")
public class DojoController {

    @Autowired
    DojoService dojoService;

    @RequestMapping("/new")
    public String newDojo(@ModelAttribute("dojo")Dojo dojo){
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/index";
        }else{
            dojoService.createDojo(dojo);
            return "redirect:/ninjas/new";
        }
    }

    @RequestMapping("/{id}")
    public String showDojo(@PathVariable("id")Long id, Model model){

        model.addAttribute("dojo", dojoService.findDojo(id));

        return "showDojo";
    }
}
