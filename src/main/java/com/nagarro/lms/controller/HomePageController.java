package com.nagarro.lms.controller;

import com.nagarro.lms.model.Book;
import com.nagarro.lms.model.Librarian;
import com.nagarro.lms.resttemplate.AuthorTemplate;
import com.nagarro.lms.resttemplate.BookTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomePageController {
    @Autowired
    private BookTemplate bookTemplate;

    @Autowired
    private AuthorTemplate authorTemplate;

    @GetMapping("/home")
    public String showHomePage(Model model,HttpSession session){
        if (session.getAttribute("userName")==null){
            model.addAttribute("librarian",new Librarian());
            return "index";
        }
        List<Book> bookList=bookTemplate.getBooks();
        model.addAttribute("bookList",bookList);
        return "homepage";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session){
        model.addAttribute("librarian",new Librarian());
        session.removeAttribute("userName");
        session.invalidate();
        return "index";
    }

    @RequestMapping("/cancel")
    public String cancel(){
        return "redirect:/home";
    }

}
