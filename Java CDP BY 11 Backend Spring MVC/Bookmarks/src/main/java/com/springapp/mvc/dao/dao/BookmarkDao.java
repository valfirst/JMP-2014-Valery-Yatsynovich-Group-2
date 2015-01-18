package com.springapp.mvc.dao.dao;

import com.springapp.mvc.dao.pojo.Bookmark;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Юлия on 1/12/15.
 */
@Repository
public class BookmarkDao extends Dao<Bookmark> {

    public BookmarkDao(){}

    @Autowired
    public BookmarkDao(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    public Bookmark getById(Integer id){
        getSession().getTransaction();
        Bookmark bookmark = getById(id);
        getSession().getTransaction().commit();
        return bookmark;
    }

    public List<Bookmark> getAll(){
        getSession().beginTransaction();
        List<Bookmark> bookmarkList = getSession().createCriteria(Bookmark.class).list();
        getSession().getTransaction().commit();
        return bookmarkList;
    }

    public void addBookmark(Bookmark bookmark){
        getSession().beginTransaction();
        add(bookmark);
        getSession().getTransaction().commit();
    }

    public void deleteById(Bookmark bookmark){
        getSession().beginTransaction();
        delete(bookmark);
        getSession().getTransaction().commit();
    }

}
