package io.carlosarosemena.thecode.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class Main {

    @RequestMapping("/")
    public String index(HttpSession session){
        Boolean isIncorrect = (Boolean) session.getAttribute("isIncorrect");

        if(isIncorrect == null){
            session.setAttribute("isIncorrect", true);
        }

        return "index";
    }

    @RequestMapping("/processCode")
    public String processCode(@RequestParam("code")String code, RedirectAttributes redirectAttributes, HttpSession session){
        Boolean isIncorrect = (Boolean) session.getAttribute("isIncorrect");

        if(code.equals("bushido")){
            session.setAttribute("isIncorrect", false);
            return "redirect:/code";
        }else{
            redirectAttributes.addFlashAttribute("error","You must train harder");
            return "redirect:/";

        }
    }

    @RequestMapping("/code")
    public String code(HttpSession session, RedirectAttributes redirectAttributes){
        Boolean isIncorrect = (Boolean) session.getAttribute("isIncorrect");

        if(isIncorrect){
            redirectAttributes.addFlashAttribute("error","You tried to cheat, You must train harder");
            return "redirect:/";
        }else{

            return "code";
        }

    }

}
