package com.test.BooksSpringHomework.Controllers;

import com.test.BooksSpringHomework.Models.Book;
import com.test.BooksSpringHomework.Repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class BookController {

        @Autowired
        private BookRepository repository;

    @GetMapping("/bookMain")
    public String bookMain(Model model)
    {
        Iterable<Book>books = repository.findAll();
        model.addAttribute("books", books);
        return "bookMain";
    }

    @GetMapping("/addBook")
    public String addBook(Model model) {

        return "/addBook";
    }
    @PostMapping("/addBook")
    public String createPost(@RequestParam String title, @RequestParam String author, @RequestParam int year,
                             @RequestParam String genre, @RequestParam int countPage, @RequestParam String description,
                             Model model) {
        Book book = new Book(title, author,genre, year,countPage,description);
        repository.save(book);
        return "redirect:/bookMain";
    }

    @GetMapping("/bookById/{id}")
    public String bookById(@PathVariable(value = "id") Long id, Model model) {
        if (!repository.existsById(id)) {
            return "redirect:/main";
        }
        Book book = repository.findById(id).get();
        model.addAttribute("book", book);
        return "bookById";
    }

    @GetMapping("bookDelete/{id}")
    public String remove(@PathVariable(value = "id") Long id, Model model) {
        if (!repository.existsById(id)) {
            return "redirect:/blog";
        }
        Book book = repository.findById(id).get();
        repository.delete(book);
        return "redirect:/bookMain";
    }

    @GetMapping("/editBook/{id}")
    public String blogEdit(@PathVariable Long id, Model model) {

        Book book = repository.findById(id).get();
        model.addAttribute("book", book);
        return "editBook";
    }

    @PostMapping("/bookEditSave/{id}")
    public String blogEditSave(@PathVariable Long id,@RequestParam String title, @RequestParam String author, @RequestParam int year,
                               @RequestParam String genre, @RequestParam int countPage,
                               @RequestParam String description, Model model)
    {
        Book book = repository.findById(id).get();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setYear(year);
        book.setPageCount(countPage);
        book.setDescription(description);
        repository.save(book);
        return "redirect:/bookMain";

    }
}
