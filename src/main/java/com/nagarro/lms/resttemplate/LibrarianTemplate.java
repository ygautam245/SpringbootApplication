package com.nagarro.lms.resttemplate;

import com.nagarro.lms.model.Librarian;

public interface LibrarianTemplate {

    Librarian getLibrarian(String userName);

    void addLibrarian(Librarian librarian);

    void updateLibrarian(Librarian newLibrarian);
}
