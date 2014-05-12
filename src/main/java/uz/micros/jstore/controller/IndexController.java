package uz.micros.jstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String showIndex() {
        return "<h2>Hello world</h2>" +
                "" +
                "<a href=\"home\">Home</a>";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }
}