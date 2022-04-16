package com.skilldistillery.jpacrudweather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.jpacrudweather.data.PointDAO;

@Controller
public class PointController {
	
	@Autowired
	private PointDAO dao;
	
	@RequestMapping(path={"/", "home.do"})
	public String home(Model model) {
		model.addAttribute("DEBUG", dao.findById(1));
		return "home";
	}

}
