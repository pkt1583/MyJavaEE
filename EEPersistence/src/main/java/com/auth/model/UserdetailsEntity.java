package com.auth.model;

import javax.persistence.*;

/**
 * Created by pankaj on 24-05-2015.
 */
@Entity
@Table(name = "userdetails", schema = "", catalog = "assign")
public class UserdetailsEntity {
    private String userId;
    private String userPassword;
    private int id;

    @Basic
    @Column(name = "userId", nullable = true, insertable = true, updatable = true, length = 20)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "userPassword", nullable = true, insertable = true, updatable = true, length = 20)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserdetailsEntity that = (UserdetailsEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
