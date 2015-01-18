package com.springapp.mvc.dao.dao;

import java.io.Serializable;

/**
 * Created by Юлия on 1/11/15.
 */
public interface IDao<T> {

    void add(T t);
    void delete(T t);
    void update(T t);
    T get(Class<T> clazz, Serializable id);
    void refresh(T t);

}
