package by.it.academy.dao;


import by.it.academy.pojos.Books;
import by.it.academy.pojos.Genres;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BooksDao extends BaseDao<Books> {
    public BooksDao() {
    }

    @Autowired
    public BooksDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Books> getAll(String contextSearch, boolean search, String contextSorted, boolean sorted, int start, int max, boolean forAllPage, Genres genre ) {

        List<Books> all = null;

        Criteria cr = getSession().createCriteria(Books.class);
        if(genre!=null){
            cr.add(Restrictions.like("genre",genre));
        }
        if (search == true) {
            cr.add(Restrictions.like("name","%" + contextSearch + "%"));
        }
        if (sorted == true) {
            cr.addOrder(Order.asc(contextSorted));
        }

        if (forAllPage == false) {
            cr.setFirstResult(start);
            cr.setMaxResults(max);
        }
        all = cr.list();

        return all;
    }

    public Books getById(Integer id) {
        return (Books) getSession().get(Books.class, id);
    }



    public List<Books> getAll(){
        return getSession().createCriteria(Books.class).list();
    }


}
