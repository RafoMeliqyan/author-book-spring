package am.authorbokk.bookdemo.controller;

import am.authorbokk.bookdemo.model.Author;
import am.authorbokk.bookdemo.model.Book;
import am.authorbokk.bookdemo.repository.AuthorRepository;
import am.authorbokk.bookdemo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MainController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String homePage(ModelMap map,@RequestParam(name = "msg", required = false) String msg) {
        List<Author> all = authorRepository.findAll();
        map.addAttribute("authors", all);
        map.addAttribute("msg", msg);
        return "home";
    }


}
