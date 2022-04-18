package com.skilldistillery.jpacrudweather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpacrudweather.data.PointDAO;
import com.skilldistillery.jpacrudweather.entities.Point;

@Controller
public class PointController {
	
	@Autowired
	private PointDAO dao;
	
	@RequestMapping(path="loc-all")
	public String getAllLocPoints(Model model) {
		model.addAttribute("list", dao.findAll());
		return "loc_all";
	}
	
	@RequestMapping(path="loc-single.do", method = RequestMethod.GET)
	public ModelAndView getLocPoint(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Point point = dao.findById(id);
		mv.addObject("point", point);
		mv.setViewName("loc_single");
		return mv;
	}
	
//	@RequestMapping(path="add-location.do", method = RequestMethod.POST)
//	public String addLocation(@RequestParam(name = "name") String name,
//									@RequestParam Integer category,
//									@RequestParam Double latitude,
//									@RequestParam Double longitude,
//									@RequestParam Integer elevation) {
//		int newId = 4;
//		System.out.println(name);
//		int newId = dao.addPoint(point);
//		boolean isAdded = (newId != -1);
		
		
//		return "redirect:/loc-single.do?id=" + newId;
//	}
	
	@RequestMapping(path="add-location.do", method = RequestMethod.POST)
	public String addLocation(Model model, Point point) {
		int newId = dao.addPoint(point);
//		boolean isAdded = (newId != -1); for verifying if successful or not
		return "redirect:/loc-single.do?id=" + newId;
	}
	
}
