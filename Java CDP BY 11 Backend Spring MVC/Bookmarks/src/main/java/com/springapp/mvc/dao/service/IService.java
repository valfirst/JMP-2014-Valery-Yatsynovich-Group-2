package com.springapp.mvc.dao.service;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by Юлия on 1/13/15.
 */
public interface IService<T> {

    void add(T t);

    void update(T t);

    T get(Class<T> clazz, Serializable id);

    void delete(T t);

    void refresh(T t);

}
