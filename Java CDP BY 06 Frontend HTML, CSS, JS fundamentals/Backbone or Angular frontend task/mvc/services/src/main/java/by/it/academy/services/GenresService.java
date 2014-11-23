package by.it.academy.services;


import by.it.academy.dao.GenresDao;
import by.it.academy.pojos.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenresService extends BaseService<Genres> {

    public GenresService() {
    }

    @Autowired
    public GenresService(GenresDao genresDao) {
        this.genresDao=genresDao;
    }

    private GenresDao genresDao;


    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Genres getById(int id) {
        return  genresDao.getById(id);
    }


    public List<Genres> getAll(){
        return genresDao.getAll();
    }



    /*




    public int pagesPagination(int max, int idGenre) {
        int allPage;
        int allSize;
        Set<Books> listSet = null;
        try {
            listSet = genresDao.getById(idGenre).getBooks();

        } catch (DaoException e) {
            e.printStackTrace();
        }
        allSize = listSet.size();
        if (allSize % max == 0) {
            allPage = allSize / max;
        } else {
            allPage = allSize / max + 1;
        }
        return allPage;
    }
*/


/*    public List<Books> getByIdGenres(int start, int max, int id) {

        List<Books> all = null;

        all = genresDao.getAll(start, max, id);


        return all;
    }*/


}
