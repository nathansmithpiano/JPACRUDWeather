package com.skilldistillery.jpacrudweather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.jpacrudweather.data.CategoryDAO;
import com.skilldistillery.jpacrudweather.data.PointDAO;
import com.skilldistillery.jpacrudweather.entities.Category;
import com.skilldistillery.jpacrudweather.entities.Point;

@Controller
public class PointController {
	
	@Autowired
	private PointDAO pointDAO;
	
	@Autowired
	private CategoryDAO catDAO;
	
	@RequestMapping(path="add-location.do", method = RequestMethod.POST)
	public String addLocation(Model model, Point point, @RequestParam("new_cat_text") String newCatName) {
		//add new category
		if (point.getCategoryId() == -1) {
			Category newCat = new Category();
			newCat.setName(newCatName);
			int newCatId = catDAO.addCategory(newCat);
			point.setCategoryId(newCatId);
		}
		
		System.out.println("*** RANGE ID: " + point.getRangeId());
		
		//TODO: add range stuff like category
		
		int newId = pointDAO.addPoint(point);
		return "redirect:/loc?id=" + newId;
	}
	
	@RequestMapping(path="update-location.do", method = RequestMethod.POST)
	public String updateLocation(Model model, Point point) {
		pointDAO.updatePoint(point.getId(), point);
		return "redirect:/loc?id=" + point.getId();
	}
	
}
