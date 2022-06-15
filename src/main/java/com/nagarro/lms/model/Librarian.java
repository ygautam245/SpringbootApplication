package com.nagarro.lms.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Librarian {

    @NotNull(message = "Required")
    @Size(min = 5, max = 50, message = "size must be between 5-50")
    private String password;

    @NotNull(message = "Required")
    @Size(min = 5, max = 50, message = "size must be between 5-50")
    private String userName;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
