package io.carlosarosemena.relationships.controllers;

import io.carlosarosemena.relationships.models.Person;
import io.carlosarosemena.relationships.services.DMVService;
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
@RequestMapping("/persons")
public class PersonsCtrl {
    @Autowired
    private DMVService dmv;

    @RequestMapping("/new")
    public String newPerson(@ModelAttribute("person")Person person){
        return "newperson";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createPerson(@ModelAttribute("person") Person person){

            dmv.createPerson(person);
            return "redirect:/licenses/new";

    }

    @RequestMapping("/{id}")
    public String showPerson(@PathVariable("id") Long id, Model model){
        model.addAttribute("person", dmv.getPerson(id));
        return "show";
    }
}
