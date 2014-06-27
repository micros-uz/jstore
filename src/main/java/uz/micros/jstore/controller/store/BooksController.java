package uz.micros.jstore.controller.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.micros.jstore.entity.store.Book;
import uz.micros.jstore.service.store.BookService;

@Controller
@RequestMapping("/store/books")
public class BooksController extends BaseStoreController{

    @Autowired
    private BookService bookSvc;

    @RequestMapping("/{id}")
    public ModelAndView details(@PathVariable int id) {

        Book book = bookSvc.getById(id);

        return book != null
            ? new ModelAndView("store/details").addObject("book", book)
            : new ModelAndView("notFound");
    }
}
