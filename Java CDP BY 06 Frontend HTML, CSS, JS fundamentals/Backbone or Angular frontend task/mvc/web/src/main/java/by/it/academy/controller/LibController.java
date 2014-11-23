package by.it.academy.controller;


import by.it.academy.pojos.Author;
import by.it.academy.pojos.Books;
import by.it.academy.pojos.Genres;
import by.it.academy.services.AuthorService;
import by.it.academy.services.BaseService;
import by.it.academy.services.BooksService;
import by.it.academy.services.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping("/book")
public class LibController {



    @Autowired
    private GenresService genresService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BooksService booksService;


    @Autowired
    private BaseService<Books> baseService;



    @Secured("ROLE_USER")
    @RequestMapping(value = "/main", method = {RequestMethod.GET, RequestMethod.POST})
    public String mainPage(ModelMap model, HttpSession session,
                           @RequestParam(value = "contextSearch", defaultValue = "") String contextSearch,
                           @RequestParam(value = "contextSorted", defaultValue = "price") String contextSorted,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "max", defaultValue = "3") int max
    ) {
        String url="main";
        if((Integer) session.getAttribute("max")!=null){
            max=(Integer) session.getAttribute("max");
        }
        model.addAttribute("url", url);
        model.addAttribute("allGenres", genresService.getAll());
        model.addAttribute("allBooks", booksService.getAllBooks(contextSearch, contextSorted, page, max));
        model.addAttribute("allPage", booksService.getAllPage());
        model.addAttribute("genres", new Genres());
        model.addAttribute("book", new Books());
        return "book/main";
    }

    @RequestMapping(value = "/genres", method = {RequestMethod.GET, RequestMethod.POST})
    public String genreBook(ModelMap model,HttpSession session,  @ModelAttribute("genres") Genres genres,
                            @RequestParam(value = "contextSearch", defaultValue = "") String contextSearch,
                            @RequestParam(value = "contextSorted", defaultValue = "price") String contextSorted,
                            @RequestParam(value = "page", defaultValue = "1") int page,
                            @RequestParam(value = "max", defaultValue = "1") int max)
    {
        String url="genres";
        if((Integer) session.getAttribute("max")!=null){
            max=(Integer) session.getAttribute("max");
        }
        model.addAttribute("url", url);
        model.addAttribute("allGenres", genresService.getAll());
        model.addAttribute("allBooks", booksService.getAllBooksByGenre(contextSearch, contextSorted, page, max, genres));
        model.addAttribute("allPage", booksService.getAllPage());
        model.addAttribute("book", new Books());
        return "book/genre";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteBook(ModelMap model,  @ModelAttribute("book") Books book)

    {
        baseService.delete(book);
        return "redirect:/book/main.html";
    }

    @RequestMapping(value = "/add-genre", method = {RequestMethod.GET, RequestMethod.POST})
    public String addGenre(ModelMap model,@RequestParam(value = "add-genre") String genre)

    {    Genres genres=new Genres();
        genres.setGenre(genre);
         genresService.add(genres);
        return "redirect:/book/main.html";
    }



    @RequestMapping(value = "/addBook", method = {RequestMethod.GET, RequestMethod.POST})
    public String addBook(ModelMap model,  @ModelAttribute("genres") Genres genres)
    {
        String url="genres";
        model.addAttribute("url", url);
        model.addAttribute("allGenres", genresService.getAll());
        model.addAttribute("genres", new Genres());
        model.addAttribute("book", new Books());
        model.addAttribute("listGenres", genresService.getAll());
        model.addAttribute("listAuthor", authorService.getAll());
        return "book/addBook";
    }

    @RequestMapping(value = "/addNewBook", method = {RequestMethod.GET, RequestMethod.POST})
    public String addNewBook(ModelMap model,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "idAuthor") int idAuthor,
                             @RequestParam(value = "date") String date,
                             @RequestParam(value = "price") int price,
                             @RequestParam(value = "idGenre") int idGenre,
                             @RequestParam(value = "descr") String descr)
    {

        Books books=new Books();
        books.setName(name);
        Author author=authorService.get(Author.class,idAuthor);
        Set<Author> authors = new HashSet<Author>();
        authors.add(author);
        books.setAuthorSet(authors);
        books.setDate(date);
        books.setPrice(price);
        Genres genres=genresService.get(Genres.class, idGenre);
        books.setGenre(genres);
        books.setDescr(descr);
        booksService.add(books);
        return "redirect:/book/main.html";
    }

}