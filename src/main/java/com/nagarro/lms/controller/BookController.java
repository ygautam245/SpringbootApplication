package com.nagarro.lms.controller;

import com.nagarro.lms.model.Author;
import com.nagarro.lms.model.Book;
import com.nagarro.lms.model.Librarian;
import com.nagarro.lms.resttemplate.AuthorTemplate;
import com.nagarro.lms.resttemplate.BookTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {

    @Autowired
    private AuthorTemplate authorTemplate;

    @Autowired
    private BookTemplate bookTemplate;

    @InitBinder
    public void InitBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/addBook")
    public String addBook(Model model, HttpSession session) {
        if (session.getAttribute("userName") == null) {
            model.addAttribute("librarian", new Librarian());
            return "index";
        }
        Book book = new Book();
        book.setDate(getDate());
        model.addAttribute("book", book);
        return "add-book";
    }

    @RequestMapping("/checkBook")
    public String checkBook(@Valid @ModelAttribute("book") Book book,
                            BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            Book dbBook = bookTemplate.getBook(book.getCode());
            if (dbBook == null) {
                bookTemplate.addBook(book);
                return "redirect:/home";
            }
        }
        return "add-book";
    }

    @RequestMapping("/updateBook")
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            bookTemplate.editBook(book);
            return "redirect:/home";
        }
        return "edit-book";
    }

    @GetMapping("/editBook")
    public String editBook(@RequestParam String code, Model model, HttpSession session) {
        if (session.getAttribute("userName") == null) {
            model.addAttribute("librarian", new Librarian());
            return "index";
        }
        List<String> authors = authorTemplate.getAuthors().stream().
                map(auth -> auth.getAuthorName()).collect(Collectors.toList());

        Book book = bookTemplate.getBook(code);
        model.addAttribute("book", book);
        model.addAttribute("authorList", authors);

        return "edit-book";
    }

    @GetMapping("/deleteBook")
    public String deleteBook(@RequestParam String code) {
        bookTemplate.deleteBook(code);
        return "redirect:/home";
    }

    @ModelAttribute("authorList")
    public List<String> getAuthorList() {
        return authorTemplate.getAuthors().stream().
                map(Author::getAuthorName).collect(Collectors.toList());
    }

    private String getDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yy");
        String str = formatter.format(date);
        return str;
    }

}
