package com.test.BooksSpringHomework.Controllers;

import com.test.BooksSpringHomework.Repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

//    @Autowired
//    private BookRepository repository;

    @GetMapping("/")
    public String main(@RequestParam(name = "login", required = false, defaultValue = "noName") String login,
                       @RequestParam(name = "password", required = false, defaultValue = "userPassword")
                       String password, Model model) {
        model.addAttribute("login", login);
        model.addAttribute("pass", password);

        return "main";
    }

    @GetMapping("/about")
    public String about(Model model)
    {
        return "about";
    }
}
