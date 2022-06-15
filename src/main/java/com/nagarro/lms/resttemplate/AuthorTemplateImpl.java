package com.nagarro.lms.resttemplate;

import com.nagarro.lms.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AuthorTemplateImpl implements AuthorTemplate {

    @Autowired
    private RestTemplate restTemplate;

    private final String ROOT_URL = "http://localhost:7070/lms/authors";

    @Override
    public List<Author> getAuthors() {
        ResponseEntity<Author[]> response = restTemplate.getForEntity(ROOT_URL,Author[].class);
        return Arrays.asList(response.getBody());
    }
}
