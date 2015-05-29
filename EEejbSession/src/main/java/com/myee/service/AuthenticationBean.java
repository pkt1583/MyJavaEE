package com.myee.service;

import com.auth.model.UserdetailsEntity;
import com.myee.dao.UserDao;
import com.myee.model.AuthenticationInformation;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by pankaj on 01-02-2015.
 */
@Stateless(name = "AuthenticationEJB")
public class AuthenticationBean {

    @Inject private  UserDao<UserdetailsEntity> userDao;

    public AuthenticationBean() {
    }

    public boolean authenticate (AuthenticationInformation authenticationInformation){
        UserdetailsEntity userdetailsEntity = userDao.findByUserId(authenticationInformation.getUserName());
        if(authenticationInformation.getPassword().equals(userdetailsEntity.getUserPassword())){
            authenticationInformation.setGetNextPage("success");
            return true;
        }
        return false;
    }
}
