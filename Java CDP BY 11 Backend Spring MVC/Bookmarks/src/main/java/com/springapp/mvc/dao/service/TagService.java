package com.springapp.mvc.dao.service;

import com.springapp.mvc.dao.dao.TagDao;
import com.springapp.mvc.dao.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Юлия on 1/18/15.
 */
@Service
@Transactional
public class TagService extends BaseService<TagDao>{

    @Autowired
    private TagDao tagDao;

    public TagService(){}

    @Autowired
    public TagService(TagDao tagDao){
        this.tagDao = tagDao;
    }

    public List<Tag> getAll(){
        return tagDao.getAll();
    }

    public Tag getById(Integer id){
        return tagDao.getById(id);
    }



}
