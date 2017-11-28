package io.carlosarosemena.productsandcategories.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainCtrl {

    @RequestMapping("/")
    public String index(){
        return "redirect:/products/new";
    }
}
