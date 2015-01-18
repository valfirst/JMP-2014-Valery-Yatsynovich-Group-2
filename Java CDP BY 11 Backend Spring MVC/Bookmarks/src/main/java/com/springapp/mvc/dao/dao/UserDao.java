package com.springapp.mvc.dao.dao;

import com.springapp.mvc.dao.pojo.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Юлия on 1/18/15.
 */
@Repository
public class UserDao extends Dao<User>{

    public UserDao(){}

    @Autowired
    public UserDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    public User getById(int id){
        getSession().beginTransaction();
        User user =  get(User.class, id);
        getSession().getTransaction().commit();
        return user;
    }

    public List<User> getAll(){
        getSession().beginTransaction();
        List<User> userList = getSession().createCriteria(User.class).list();
        getSession().getTransaction().commit();
        return userList;
    }
}
