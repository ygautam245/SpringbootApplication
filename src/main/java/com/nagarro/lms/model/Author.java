package com.nagarro.lms.model;

import javax.validation.constraints.NotNull;

public class Author {

    @NotNull(message = "Required")
    int authorID;

    @NotNull(message = "Required")
    String authorName;

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

}
