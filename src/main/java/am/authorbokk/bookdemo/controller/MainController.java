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

    @PostMapping("/addAuthor")
    public String addAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/?msg=Author was added";
    }

    @PostMapping("/addBook")
    public String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/?msg=Book was added";
    }

    @GetMapping("/authors")
    public String authors(ModelMap map) {
        List<Author> allAuthors = authorRepository.findAll();
        map.addAttribute("allAuthor", allAuthors);
        return "authors";
    }

    @GetMapping("/books")
    public String books(ModelMap map) {
        List<Book> allBooks = bookRepository.findAll();
        map.addAttribute("allBooks", allBooks);
        return "books";
    }

    @GetMapping("/deleteAuthor")
    public String deleteAuthor(@RequestParam("id") int id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") int id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }

    @RequestMapping("/updateAuthor")
    public String updateAuthor(ModelMap map, int id) {
        Author one = authorRepository.getOne(id);
        map.addAttribute("authors", one);
        return "updateAuthor";
    }

    @RequestMapping("/updateBook")
    public String updateBook(ModelMap map, int id) {
        List<Author> all = authorRepository.findAll();
        Book one = bookRepository.getOne(id);
        map.addAttribute("allAuthors", all);
        map.addAttribute("allBooks", one);
        return "updateBook";
    }

    @PostMapping("/updateB")
    public String updateB(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/?msg=Book was updated";
    }

    @PostMapping("/updateA")
    public String updateA(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/?msg=Author was updated";
    }

}
