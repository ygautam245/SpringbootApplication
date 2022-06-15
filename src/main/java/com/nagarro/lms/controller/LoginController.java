package com.nagarro.lms.controller;

import com.nagarro.lms.encypt.AESExample;
import com.nagarro.lms.model.Librarian;
import com.nagarro.lms.resttemplate.LibrarianTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private LibrarianTemplate librarianTemplate;

    @Autowired
    private AESExample aesExample;

    @InitBinder
    public void InitBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/")
    public String LoginUser(Model model) {
        model.addAttribute("librarian", new Librarian());
        return "index";
    }

    @RequestMapping("/validateUser")
    public String validate(@Valid @ModelAttribute("librarian") Librarian modelLibrarian,
                           BindingResult bindingResult, HttpSession session) {
        if (!bindingResult.hasErrors()) {
            Librarian dbLibrarian = librarianTemplate.getLibrarian(modelLibrarian.getUserName());
            if (dbLibrarian != null) {
                if (Authenticate(modelLibrarian, dbLibrarian)) {
                    session.setAttribute("userName", modelLibrarian.getUserName());
                    return "redirect:/home";
                }
            }
        }
        return "index";
    }

    @RequestMapping("/signup")
    public String SignUp(Model model) {
        model.addAttribute("librarian", new Librarian());
        return "sign-up";
    }

    @RequestMapping("/sign-up")
    public String SigningUp(@Valid @ModelAttribute("librarian") Librarian librarian
            , BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
//            librarian.setPassword(Base64.getEncoder().encodeToString(librarian.getPassword().
//                    getBytes(StandardCharsets.UTF_8)));
            String password = aesExample.encrypt(librarian.getPassword());
            librarian.setPassword(password);
            librarianTemplate.addLibrarian(librarian);
            model.addAttribute("librarian", new Librarian());
            return "index";
        }
        return "sign-up";
    }

    private boolean Authenticate(Librarian modelLibrarian, Librarian dbLibrarian) {
//        byte[] password=Base64.getDecoder().decode(dbLibrarian.getPassword());
//        String pass=new String(password);
        String pass = aesExample.decrypt(dbLibrarian.getPassword());
//        return pass.equals(modelLibrarian.getPassword());
        return Objects.equals(pass, modelLibrarian.getPassword());
    }

}
