package com.springapp.mvc.dao.service;

import com.springapp.mvc.dao.dao.BookmarkDao;
import com.springapp.mvc.dao.pojo.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Юлия on 1/13/15.
 */

@Service
@Transactional
public class BookmarkService extends BaseService<Bookmark> {

    @Autowired
    private BookmarkDao bookmarkDao;

    @Autowired
    public BookmarkService(BookmarkDao bookmarkDao){
        this.bookmarkDao = bookmarkDao;
    }

    public BookmarkService(){}

    public List<Bookmark> getAll(){
        return bookmarkDao.getAll();
    }

    public Bookmark getById(Integer id){
        return bookmarkDao.getById(id);
    }

    public void add(Bookmark bookmark){
        bookmarkDao.add(bookmark);
    }

    public void delete(Bookmark bookmark){
        bookmarkDao.delete(bookmark);
    }
}
