package com.nagarro.lms.model;

import javax.validation.constraints.NotNull;

public class Book {

    @NotNull(message = "Required")
    private String code;

    @NotNull(message = "Required")
    private String name;

    @NotNull(message = "Required")
    private String author;

    @NotNull(message = "Required")
    private String date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
