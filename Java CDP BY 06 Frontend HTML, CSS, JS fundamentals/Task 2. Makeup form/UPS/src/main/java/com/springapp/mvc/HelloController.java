package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value = "ups", method = RequestMethod.GET)
	public String completeDeliveryForm(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

    @RequestMapping(value = "over", method = RequestMethod.GET)
    public String success(ModelMap model){
        model.addAttribute("message", "Hello world!");
        return "success";
    }
}