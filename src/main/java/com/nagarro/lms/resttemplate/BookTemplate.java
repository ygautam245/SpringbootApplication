package com.nagarro.lms.resttemplate;

import com.nagarro.lms.model.Book;

import java.util.List;

public interface BookTemplate {
    List<Book> getBooks();

    Book getBook(String code);

    void addBook(Book book);

    void editBook(Book book);

    void deleteBook(String code);

}
