package by.it.academy.dao;

import java.io.Serializable;

public interface Dao<T> {

    void add(T t);

    void update(T t);

    T get(Class<T> clazz, Serializable id);

    void delete(T t);

    void refresh(T t);
}
