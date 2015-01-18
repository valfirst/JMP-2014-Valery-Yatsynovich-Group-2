package com.springapp.mvc.dao.dao;

import com.springapp.mvc.dao.pojo.Tag;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Юлия on 1/18/15.
 */
@Repository
public class TagDao extends Dao<Tag> {

    public TagDao(){}

    @Autowired
    public TagDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    public Tag getById(Integer id){
        getSession().beginTransaction();
        Tag tag = get(Tag.class, id);
        getSession().getTransaction().commit();
        return tag;
    }

    public List<Tag> getAll(){
        getSession().beginTransaction();
        List<Tag> tagList = getSession().createCriteria(Tag.class).list();
        getSession().getTransaction().commit();
        return tagList;
    }

}
