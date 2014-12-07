package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * Created by Julia on 12/7/14.
 */
public class WorkUnitDao<T> implements IDao<T> {

    private static Session session;
    private Transaction transaction;
    private static HibernateUtil hibernateUtil = HibernateUtil.getHibernateUtil();

    public WorkUnitDao(){}

    public Session getSession(){
         session = hibernateUtil.getSession();
        return session;
    }

    public Session getCurrentSession(){
        if(session == null){
            return getSession();
        }
        else return session;
    }

    @Override
    public void add(T t) {
         if(session == null){
             session = hibernateUtil.getSession();
         }
        this.transaction = session.beginTransaction();
        session.save(t);
        this.transaction.commit();
    }

    @Override
    public void update(T t) {
        if(session == null){
            session = hibernateUtil.getSession();
        }
        if(session.isDirty()){
            session.flush();
        }
        this.transaction = session.beginTransaction();
        session.update(t);
        this.transaction.commit();
    }

    @Override
    public void update(Class<T> clazz, Serializable id) {
        if(session == null){
            session = hibernateUtil.getSession();
        }
        if(session.isDirty()){
            session.flush();
        }
        this.transaction = session.beginTransaction();

        T t = (T) get(clazz, id);
        if(t != null){
            update(t);
        }
    }

    @Override
    public T get(Class clazz, Serializable id) {
        if(session == null){
            session = hibernateUtil.getSession();
        }
        this.transaction = session.beginTransaction();
        T t = (T) session.load(clazz, id);
        session.flush();
        this.transaction.commit();
        return t;
    }

    @Override
    public T getByGet(Class clazz, Serializable id) {
        if(session == null){
            session = hibernateUtil.getSession();
        }
        this.transaction = session.beginTransaction();
        T t = (T) session.get(clazz, id);
        this.transaction.commit();
        return t;
    }

    @Override
    public List getList(Class clazz) {
        if(session == null){
            session = hibernateUtil.getSession();
        }
        this.transaction = session.beginTransaction();
        List<T> list = session.createCriteria(clazz).list();
        this.transaction.commit();
        return list;
    }

    @Override
    public void delete(T t) {
        if(session == null){
            session = hibernateUtil.getSession();
        }
        this.transaction = session.beginTransaction();
        session.delete(t);
        this.transaction.commit();
    }

    @Override
    public void delete(Class<T> clazz, Serializable id) {
        if(session == null){
            session = hibernateUtil.getSession();
        }
        this.transaction = session.beginTransaction();

        T t = (T) get(clazz, id);
        if(t != null){
            delete(t);
        }
    }

    @Override
    public void refresh(T t) {
        if(session == null){
            session = hibernateUtil.getSession();
        }
        this.transaction = session.beginTransaction();
        session.refresh(t);
        this.transaction.commit();
    }
}
