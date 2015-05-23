package com.myee.model;

/**
 * Created by pankaj on 01-02-2015.
 */
public class AuthenticationInformation {
    private String userName;
    private String password;
    private String errorMessage;

    public String getGetNextPage() {
        return getNextPage;
    }

    public void setGetNextPage(String getNextPage) {
        this.getNextPage = getNextPage;
    }

    private String getNextPage;

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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
