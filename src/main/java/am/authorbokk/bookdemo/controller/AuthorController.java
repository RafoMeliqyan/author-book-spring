package am.authorbokk.bookdemo.controller;

import am.authorbokk.bookdemo.model.Author;
import am.authorbokk.bookdemo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    @PostMapping("/saveAuthor")
    public String addAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/?msg=Author was saved";
    }

    @GetMapping("/authors")
    public String authors(ModelMap map) {
        List<Author> allAuthors = authorRepository.findAll();
        map.addAttribute("allAuthor", allAuthors);
        return "authors";
    }

    @GetMapping("/deleteAuthor")
    public String deleteAuthor(@RequestParam("id") int id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }

    @RequestMapping("/updateAuthor")
    public String updateAuthor(@RequestParam("id") int id, ModelMap map) {
        Author one = authorRepository.getOne(id);
        map.addAttribute("authors", one);
        return "updateAuthor";
    }
}
