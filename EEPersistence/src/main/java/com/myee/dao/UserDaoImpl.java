package com.myee.dao;

import com.auth.model.UserdetailsEntity;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by pankaj on 28-05-2015.
 */
@Named
public class UserDaoImpl implements UserDao<UserdetailsEntity> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserdetailsEntity findByUserId(String userid) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserdetailsEntity> criteriaQuery = criteriaBuilder.createQuery(UserdetailsEntity.class);
        Root<UserdetailsEntity> userdetailsEntityRoot = criteriaQuery.from(UserdetailsEntity.class);
        criteriaQuery.select(userdetailsEntityRoot).where(criteriaBuilder.equal(userdetailsEntityRoot.get("userId"), userid));
        UserdetailsEntity userdetailsEntity = entityManager.createQuery(criteriaQuery).getSingleResult();
        if (userdetailsEntity == null) {
            userdetailsEntity = new UserdetailsEntity();
        }
        return userdetailsEntity;
    }
}
