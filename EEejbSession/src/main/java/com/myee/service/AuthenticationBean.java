package com.myee.service;

import com.auth.model.UserdetailsEntity;
import com.myee.model.AuthenticationInformation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by pankaj on 01-02-2015.
 */
@Stateless(name = "AuthenticationEJB")
public class AuthenticationBean {

    @PersistenceContext
    private EntityManager entityManager;

    public AuthenticationBean() {
    }
    public boolean authenticate (AuthenticationInformation authenticationInformation){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserdetailsEntity> criteriaQuery = criteriaBuilder.createQuery(UserdetailsEntity.class);
        Root<UserdetailsEntity> userdetailsEntityRoot=criteriaQuery.from(UserdetailsEntity.class);
        criteriaQuery.select(userdetailsEntityRoot).where(criteriaBuilder.equal(userdetailsEntityRoot.get("userId"),authenticationInformation.getUserName()));
        UserdetailsEntity userdetailsEntity=entityManager.createQuery(criteriaQuery).getSingleResult();

        if(authenticationInformation.getPassword().equals(authenticationInformation.getPassword())){
            authenticationInformation.setGetNextPage("success");
            return true;
        }
        return false;
    }
}
