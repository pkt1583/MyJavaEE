package com.myee.dao;

import com.myee.dao.annotations.DbEntityMager;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 * Created by tiwapan on 6/26/2015.
 */
public class Database {
    @Produces @PersistenceContext(unitName="NewPersistenceUnit") @DbEntityMager
    private EntityManager databaseEntityManager;
  /*  @Produces @PersistenceUnit(unitName="UserData") @DbEntityManagerFactory
    EntityManagerFactory userDatabaseEntityManagerFactory;*/
}