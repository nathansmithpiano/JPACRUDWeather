package com.skilldistillery.jpacrudweather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpacrudweather.data.CategoryDAO;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryDAO dao;
	
	@RequestMapping(path="loc-add", method = RequestMethod.GET)
	public ModelAndView addLocationBegin() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("categories", dao.findAll());
		mv.setViewName("loc_add");
		return mv;
	}

}
