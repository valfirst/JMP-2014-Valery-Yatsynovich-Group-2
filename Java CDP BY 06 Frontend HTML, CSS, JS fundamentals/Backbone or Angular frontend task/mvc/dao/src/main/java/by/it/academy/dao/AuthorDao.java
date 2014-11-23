package by.it.academy.dao;


import by.it.academy.pojos.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDao extends BaseDao<Author> {

    public AuthorDao() {
    }
    @Autowired
    public AuthorDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Author getById(Integer id) {
        return (Author) getSession().get(Author.class, id);
    }

    public List<Author> getAll(){
        return getSession().createCriteria(Author.class).list();
    }
}
