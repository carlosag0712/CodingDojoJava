package io.carlosarosemena.relationships.controllers;


import io.carlosarosemena.relationships.models.License;
import io.carlosarosemena.relationships.services.DMVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/licenses")
public class LicenseCtrl {

    @Autowired
    DMVService dmv;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false  ));
    }

    @RequestMapping("/new")
    public String newLicense(@ModelAttribute("license")License license, Model model){
        model.addAttribute("persons", dmv.allPersons());
        return "newlicense";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createLicense(@Valid @ModelAttribute License license, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("persons", dmv.allPersons());
            return "newlicense";
        }else{

            License lic = dmv.createLicense(license);
            String personId = Long.toString(lic.getPerson().getId());
            return "redirect:/persons/".concat(personId);

        }
    }

}
