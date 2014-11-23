package by.it.academy.services;


import by.it.academy.dao.AuthorDao;
import by.it.academy.pojos.Author;
import by.it.academy.pojos.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService extends BaseService<Author> {

    public AuthorService() {

    }

    @Autowired
    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    private AuthorDao authorDao;

    public List<Author> getAll(){
        return authorDao.getAll();
    }

}
