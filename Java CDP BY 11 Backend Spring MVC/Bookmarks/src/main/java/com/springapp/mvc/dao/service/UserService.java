package com.springapp.mvc.dao.service;

import com.springapp.mvc.dao.dao.UserDao;
import com.springapp.mvc.dao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Юлия on 1/18/15.
 */
@Service
@Transactional
public class UserService extends BaseService<User> {

    @Autowired
    private UserDao userDao;

    public UserService(){}

    @Autowired
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public List<User> getAll(){
        return userDao.getAll();
    }

    public User getById(Integer id){
        return userDao.getById(id);
    }


}
