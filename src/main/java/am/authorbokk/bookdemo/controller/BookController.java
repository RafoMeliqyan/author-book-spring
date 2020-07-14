package am.authorbokk.bookdemo.controller;

import am.authorbokk.bookdemo.model.Author;
import am.authorbokk.bookdemo.model.Book;
import am.authorbokk.bookdemo.repository.AuthorRepository;
import am.authorbokk.bookdemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @PostMapping("/saveBook")
    public String addBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/?msg=Book was saved";
    }

    @GetMapping("/books")
    public String books(ModelMap map) {
        List<Book> allBooks = bookRepository.findAll();
        map.addAttribute("allBooks", allBooks);
        return "books";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam("id") int id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }

    @RequestMapping("/updateBook")
    public String updateBook(@RequestParam("id") int id, ModelMap map) {
        List<Author> all = authorRepository.findAll();
        Book one = bookRepository.getOne(id);
        map.addAttribute("allAuthors", all);
        map.addAttribute("allBooks", one);
        return "updateBook";
    }
}
