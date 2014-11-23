package by.it.academy.dao;


import by.it.academy.pojos.Genres;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenresDao extends BaseDao<Genres> {
    public GenresDao() {

    }

    @Autowired
    public GenresDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    private static Logger logger = Logger.getLogger(GenresDao.class);


 /*   public List<Books> getAll(int start, int max, int idGenre) {
        List<Books> list;
        Query query = getSession().createQuery("FROM Books B WHERE B.genre.id=" + idGenre);
        query.setFirstResult(start);
        query.setMaxResults(max);
        list = query.list();
        return list;
    }*/


    public Genres getById(int id) {
        return (Genres) getSession().get(Genres.class, id);
    }

    public List<Genres> getAll(){
        return getSession().createCriteria(Genres.class).list();
    }

}
