package com.springapp.mvc.controller;

import com.springapp.mvc.dao.pojo.Bookmark;
import com.springapp.mvc.dao.pojo.Tag;
import com.springapp.mvc.dao.pojo.User;
import com.springapp.mvc.dao.service.BookmarkService;
import com.springapp.mvc.dao.service.TagService;
import com.springapp.mvc.dao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private BookmarkService bookmarkService;
    @Autowired
    private TagService tagService;
    @Autowired
    private UserService userService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView printWelcome(HttpServletRequest request, HttpServletResponse response) { //HttpServletRequest request, HttpServletResponse response

        List<Bookmark> bookmarkList = bookmarkService.getAll();
        List<Tag> tagList = tagService.getAll();

        ModelAndView modelAndView = new ModelAndView("hello", "bookmarkList", bookmarkList);
        modelAndView.addObject("message", "Hello, my dear friend!!!");
        modelAndView.getModel().put("bookmark", new Bookmark());
        modelAndView.addObject("bookmark", new Bookmark());
		return modelAndView;
	}

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public String addBook(ModelMap model){
        model.addAttribute("allTags", tagService.getAll());
        model.addAttribute("tag", new Tag());
        model.addAttribute("allUsers", userService.getAll());
        model.addAttribute("user", new User());
        return "add";
    }

    @RequestMapping(value = "/edit",  method = {RequestMethod.GET, RequestMethod.POST})
    public String editBookmark(ModelMap model, @ModelAttribute("bookmark") Bookmark bookmark){
        model.addAttribute("bookmark", bookmark);
        return "edit";
    }

    @RequestMapping(value = "/addNewBookmark", method = {RequestMethod.POST, RequestMethod.GET})
    public String addBook(Model model,
                                @RequestParam(value = "title") String title,
                                @RequestParam(value = "url") String url,
                                @RequestParam(value = "user") int userId,
                                @RequestParam(value = "tag") int tagId){

        Bookmark bookmark = new Bookmark();
        bookmark.setId_bookmark(bookmarkService.getAll().size() + 1);
        bookmark.setUrl(url);
        bookmark.setTitle(title);
        Tag tag = tagService.getById(tagId);
        User user = userService.getById(userId);
        bookmark.setTag_id(tag);
        bookmark.setUser(user);
        bookmarkService.add(bookmark);

        return "redirect:/hello.html";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteBookmark(ModelMap modelMap, @ModelAttribute("bookmark") Bookmark bookmark){
         bookmarkService.delete(bookmark);
        return "redirect:/hello.html";
    }

}