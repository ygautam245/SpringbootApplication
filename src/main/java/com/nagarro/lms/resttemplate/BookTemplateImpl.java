package com.nagarro.lms.resttemplate;

import com.nagarro.lms.model.Author;
import com.nagarro.lms.model.Book;
import com.nagarro.lms.model.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class BookTemplateImpl implements BookTemplate {

    @Autowired
    private RestTemplate restTemplate;

    private final String ROOT_URL = "http://localhost:7070/lms/books";

    @Override
    public List<Book> getBooks() {
        ResponseEntity<Book[]> response = restTemplate.getForEntity(ROOT_URL, Book[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public Book getBook(String code) {
        String url = ROOT_URL + "/" + code;
        ResponseEntity<Book> response=null;
        try {
            response = restTemplate.getForEntity(url, Book.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (response==null){
            return null;
        }
        return response.getBody();
    }

    @Override
    public void addBook(Book book) {
        restTemplate.postForEntity(ROOT_URL, book, String.class);
    }

    @Override
    public void editBook(Book book) {
        restTemplate.put(ROOT_URL, book);
    }

    @Override
    public void deleteBook(String code) {
        restTemplate.delete(ROOT_URL + "/" + code);
    }

}
