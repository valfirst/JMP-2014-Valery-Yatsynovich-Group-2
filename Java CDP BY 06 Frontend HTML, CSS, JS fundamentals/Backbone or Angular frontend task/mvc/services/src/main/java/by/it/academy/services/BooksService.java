package by.it.academy.services;


import by.it.academy.dao.BooksDao;
import by.it.academy.pojos.Books;
import by.it.academy.pojos.Genres;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BooksService extends BaseService<Books> {

    public BooksService() {

    }

    @Autowired
    public BooksService(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    private BooksDao booksDao;

    private int allPage=1;

    public int getAllPage() {
        return allPage;
    }

    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }


    private List<Books> getAll(String contextSearch, String contextSorted,  int page, int max, Genres genre) {
        boolean search=true;
        boolean sorted=true;
        if (contextSearch==null | contextSearch==""){
          search=false;
        }
        if(contextSorted==null | contextSorted==""){
            sorted=false;
        }
        int start = max * page - max;
        boolean forAllPage = false;
        List<Books> all = null;
        int allSize;
        try {

            all = booksDao.getAll(contextSearch, search, contextSorted, sorted, start, max, forAllPage, genre);
            forAllPage = true;
            allSize = (booksDao.getAll(contextSearch, search, contextSorted, sorted, start, max, forAllPage,genre).size());
            if (allSize % max == 0) {
                setAllPage(allSize / max);
            } else {
                setAllPage(allSize / max + 1);
            }
        } catch (HibernateException e) {

            e.printStackTrace();
        }
        return all;
    }


    public List<Books> getAllBooks(String contextSearch, String contextSorted,  int page, int max){
        Genres genre=null;
        return getAll(contextSearch, contextSorted, page,  max, genre);
    }

    public List<Books> getAllBooksByGenre(String contextSearch, String contextSorted,  int page, int max, Genres genre){
        return getAll(contextSearch, contextSorted, page,  max, genre);
    }


    public List<Books> sorted() {


        return null;
    }


}


