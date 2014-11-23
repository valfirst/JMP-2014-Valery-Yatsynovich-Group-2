
package by.it.academy.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class BaseDao<T> implements Dao<T> {
    private static Logger log = Logger.getLogger(BaseDao.class);
    private SessionFactory sessionFactory;

    public BaseDao() {
    }

    @Autowired
    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void add(T t) {
        getSession().saveOrUpdate(t);
        log.info("Save:" + t);
    }

    @Override
    public void update(T t) {
        getSession().update(t);
        log.info("Update:" + t);
    }

    @Override
    public T get(Class<T> clazz, Serializable id) {
        log.info("Get:" + id);
        return (T) getSession().get(clazz,id);
    }

    @Override
    public void delete(T t) {
        log.info("Delete:" + t);
        getSession().delete(t);
    }

    @Override
    public void refresh(T t) {
        log.info("Refresh:" + t);
        getSession().refresh(t);
    }





}
