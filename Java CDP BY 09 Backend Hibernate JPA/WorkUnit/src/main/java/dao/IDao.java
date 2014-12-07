package dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Julia on 12/7/14.
 */
public interface IDao<T> {

    void add(T t);
    void update(T t);
    void update(Class<T> clazz, Serializable id);
    T get(Class<T> clazz, Serializable id);
    T getByGet(Class<T> clazz, Serializable id);
    List<T> getList(Class<T> clazz);
    void delete(T t);
    void delete(Class<T> clazz, Serializable id);
    void refresh(T t);


}
