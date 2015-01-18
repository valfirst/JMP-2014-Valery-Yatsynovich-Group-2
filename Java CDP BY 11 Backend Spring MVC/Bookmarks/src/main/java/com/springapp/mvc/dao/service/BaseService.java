package com.springapp.mvc.dao.service;

import com.springapp.mvc.dao.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * Created by Юлия on 1/13/15.
 */
@Service
@Transactional
public class BaseService<T> implements IService<T> {

    public BaseService(){}

    @Autowired
    private Dao<T> dao;

    @Autowired
    public BaseService(Dao<T> dao){
        this.dao = dao;
    }

    @Override
    public void add(T t) {
        dao.add(t);
    }

    @Override
    public void update(T t) {
       dao.update(t);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public T get(Class<T> clazz, Serializable id) {
        return dao.get(clazz, id);
    }

    @Override
    public void delete(T t) {
        dao.delete(t);
    }

    @Override
    public void refresh(T t) {
       dao.refresh(t);
    }
}
