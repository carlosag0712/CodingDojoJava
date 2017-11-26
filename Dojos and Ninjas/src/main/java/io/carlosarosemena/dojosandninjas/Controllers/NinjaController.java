package io.carlosarosemena.dojosandninjas.Controllers;

import io.carlosarosemena.dojosandninjas.Models.Ninja;
import io.carlosarosemena.dojosandninjas.Services.DojoService;
import io.carlosarosemena.dojosandninjas.Services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {

    @Autowired
    NinjaService ninjaService;

    @Autowired
    DojoService dojoService;

    @RequestMapping("/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model){
        model.addAttribute("dojos", dojoService.getAll());
        return "ninjaform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result){
        if(result.hasErrors()){
            return "new";
        } else {
            Ninja n = ninjaService.createNinja(ninja);
            String dojoId = Long.toString(n.getDojo().getId());
            return "redirect:/dojos/".concat(dojoId);
        }

    }
}
