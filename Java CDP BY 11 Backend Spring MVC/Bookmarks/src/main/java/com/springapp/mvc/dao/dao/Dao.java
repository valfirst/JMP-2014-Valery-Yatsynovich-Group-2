package com.springapp.mvc.dao.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Юлия on 1/11/15.
 */
@Repository
public class Dao<T> implements IDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public Dao(){}

    @Autowired
    public Dao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(T t) {
         getSession().saveOrUpdate(t);
    }

    @Override
    public void delete(T t) {
         getSession().delete(t);
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public T get(Class<T> clazz, Serializable id) {
        return (T) getSession().get(clazz, id);
    }

    @Override
    public void refresh(T t) {
        getSession().refresh(t);
    }
}
