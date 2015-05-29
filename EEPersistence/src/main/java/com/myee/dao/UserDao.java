package com.myee.dao;

import javax.inject.Named;


public interface UserDao<T> {
    T findByUserId(String userid);
}
