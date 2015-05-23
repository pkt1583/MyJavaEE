package com.myee.service;

import com.myee.model.AuthenticationInformation;

import javax.ejb.Stateless;

/**
 * Created by pankaj on 01-02-2015.
 */
@Stateless(name = "AuthenticationEJB")
public class AuthenticationBean {
    public AuthenticationBean() {
    }
    public boolean authenticate (AuthenticationInformation authenticationInformation){
        if(authenticationInformation.getPassword().equals(authenticationInformation.getPassword())){
            authenticationInformation.setGetNextPage("success");
            return true;
        }
        return false;
    }
}
