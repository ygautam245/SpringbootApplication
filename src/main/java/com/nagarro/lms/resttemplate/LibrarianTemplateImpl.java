package com.nagarro.lms.resttemplate;

import com.nagarro.lms.model.Book;
import com.nagarro.lms.model.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LibrarianTemplateImpl implements LibrarianTemplate {

    @Autowired
    private RestTemplate restTemplate;

    private final String ROOT_URL = "http://localhost:7070/lms/librarians";

    @Override
    public Librarian getLibrarian(String userName) {
        String url = ROOT_URL + "/" + userName;
        ResponseEntity<Librarian> response=null;
        try {
            response = restTemplate.getForEntity(url,Librarian.class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (response==null){
            return null;
        }
        return response.getBody();
    }

    @Override
    public void addLibrarian(Librarian librarian) {
        restTemplate.postForEntity(ROOT_URL, librarian, String.class);
    }

    @Override
    public void updateLibrarian(Librarian newLibrarian) {
        restTemplate.put(ROOT_URL, Librarian.class);
    }
}
