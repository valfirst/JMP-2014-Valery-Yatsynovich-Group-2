package by.it.academy.services;

import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public interface IService<T> {

    void add(T t);

    void update(T t);

    T get(Class<T> clazz, Serializable id);

    void delete(T t);

    void refresh(T t);
}
