package uz.micros.jstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.jstore.entity.store.Author;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    public ModelAndView home(HttpSession session) {
        Author a = new Author();
        a.setName("Akbar");

        List<Author> list;
        if (session.getAttribute("authors") == null) {
            list = new ArrayList<>();
            list.add(a);
            list.add(a);
            list.add(a);
            session.setAttribute("authors", list);
        } else
            list = (List<Author>) session.getAttribute("authors");

        return new ModelAndView("home")
                .addObject("name", "John")
                .addObject("author", a)
                .addObject("authors", list);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam String title, HttpSession session) {
        List<Author> list = (List<Author>) session.getAttribute("authors");

        Author a = new Author();
        a.setName(title);

        list.add(a);

        return "redirect:/";
    }
}