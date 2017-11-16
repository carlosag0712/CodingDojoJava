package io.carlosarosemena.counter.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.net.Inet4Address;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(HttpSession session){
        Integer count = (Integer) session.getAttribute("count");

        if(count == null){
            session.setAttribute("count", 0);
        }else{
            Integer currentCount = count+1;
            session.setAttribute("count", currentCount);
        }

        return "index";
    }

    @RequestMapping("/doublecounter")
    public String doublecounter(HttpSession session){
        Integer count = (Integer) session.getAttribute("count");
        if(count == null){
            session.setAttribute("count", 0);
        }else{
            Integer currentCount = count + 2;
            session.setAttribute("count", currentCount);
        }

        return "index2";
    }

    @RequestMapping("/counter")
    public String counter(){
        return "counter";
    }

    @RequestMapping("/reset")
    public String reset(HttpSession session){

        Integer count = (Integer) session.getAttribute("count");
        if(count >0){
            session.setAttribute("count", 0);

        }

        return "index";


    }

}



