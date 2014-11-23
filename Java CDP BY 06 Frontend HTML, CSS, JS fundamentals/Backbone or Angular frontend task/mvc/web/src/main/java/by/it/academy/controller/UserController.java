
package by.it.academy.controller;

import by.it.academy.pojos.Genres;
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

@Controller
public class UserController {

    @Autowired
    private GenresService genresService;


    @Autowired
    private BooksService booksService;


    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {

        return "login_page";

    }

    @RequestMapping(value="/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login_page";

    }


    @RequestMapping(value="/main", method = RequestMethod.GET)
    public String main(ModelMap model) {
        return "redirect:/book/main.html";
    }


    @Secured("ROLE_USER")
    @RequestMapping(value = "/account", method = {RequestMethod.GET, RequestMethod.POST})
    public String account(ModelMap model, HttpSession session,
                          @RequestParam(value = "max", defaultValue = "3") int max,
                          @ModelAttribute("genres") Genres genres,
                          @RequestParam(value = "contextSearch", defaultValue = "") String contextSearch,
                          @RequestParam(value = "contextSorted", defaultValue = "price") String contextSorted,
                          @RequestParam(value = "page", defaultValue = "1") int page
                          ){
        String url="book/genres";
        model.addAttribute("url", url);
        model.addAttribute("allGenres", genresService.getAll());
        model.addAttribute("allBooks", booksService.getAllBooksByGenre(contextSearch, contextSorted, page, max, genres));
        model.addAttribute("allPage", booksService.getAllPage());

        session.setAttribute("max",max);
        return "account";
    }


    /*private static List<Person> personList = new ArrayList();

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage(ModelMap model) {
        model.put("persons", personList);
        Person person = new Person();
        person.setName("Yuli");
        model.put("person", person);
        return "user/main";
    }

    //@PreAuthorize("APP_ROLE")
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String userInfo() {

        return "user/info";
    }

    @RequestMapping(value = "/add-person", method = {RequestMethod.POST})
    public String addPerson(ModelMap model, @Valid Person person, BindingResult bindingResult) {
        personList.add(person);
        if (!bindingResult.hasErrors()) {
            model.put("persons", personList);
            model.put("person", person);
        }

        return "user/main";
    }

    @RequestMapping(value = "/person-info", method = {RequestMethod.GET})
    public String infoPerson(ModelMap model, @RequestParam(value = "personId", defaultValue = "") Integer id) {

        model.put("person", personList.get(id));

        return "user/info";
    }

    @RequestMapping(value = "/update-person", method = {RequestMethod.POST})
    public String updatePerson(ModelMap model, @Valid Person person, BindingResult bindingResult,
                               @RequestParam(value = "id", defaultValue = "0") Integer id) {
        personList.remove(id);
        personList.add(person);
        if (!bindingResult.hasErrors()) {
            model.put("persons", personList);
            model.put("person", person);
        }

        return "user/main";
    }

    @RequestMapping(value = "/delete-person", method = RequestMethod.GET)
    public String deletePerson(ModelMap modelMap,@Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

        } else {
            personList.remove(userForm.getPersonId());
        }

        modelMap.put("persons", personList);
        modelMap.put("person", new Person());

        return "user/main";
    }*/
}
