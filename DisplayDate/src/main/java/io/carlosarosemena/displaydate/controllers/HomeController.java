package io.carlosarosemena.displaydate.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
    private static Date currentDate = new Date();
    private static SimpleDateFormat formatter;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/date")
    public String date(Model model){
        formatter = new SimpleDateFormat("EEEE, 'the ' d 'of' MMMM, yyyy");
        String formattedDate = formatter.format(currentDate);
        model.addAttribute("date", formattedDate);

        return "date";
    }

    @RequestMapping("/time")
    public String time(Model model){
        formatter = new SimpleDateFormat("hh:mm aa");
        String formattedDate = formatter.format(currentDate);
        model.addAttribute("time", formattedDate);
        return "time";
    }



}
