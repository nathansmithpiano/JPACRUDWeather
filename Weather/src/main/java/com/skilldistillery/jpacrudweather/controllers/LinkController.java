package com.skilldistillery.jpacrudweather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.jpacrudweather.data.CategoryDAO;
import com.skilldistillery.jpacrudweather.data.PointDAO;
import com.skilldistillery.jpacrudweather.data.RangeDAO;
import com.skilldistillery.jpacrudweather.entities.Point;

@Controller
public class LinkController {
	
	@Autowired
	private CategoryDAO catDAO;
	
	@Autowired
	private PointDAO pointDAO;
	
	@Autowired
	private RangeDAO rangeDAO;
	
	@RequestMapping(path= {"/", "index"})
	public String home() {
		return "index";
	}
	
	@RequestMapping(path={"loc-co14ers"})
	public ModelAndView co14ers() {
		ModelAndView mv = new ModelAndView();
		addLinkingTables(mv);
		mv.addObject("list", pointDAO.findByCategoryIds(new int[] {1}));
		mv.setViewName("loc_co_14ers");
		return mv;
	}
	
	@RequestMapping(path={"loc-co13ers"})
	public ModelAndView co13ers() {
		ModelAndView mv = new ModelAndView();
		addLinkingTables(mv);
		mv.addObject("list", pointDAO.findByCategoryIds(new int[] {2}));
		mv.setViewName("loc_co_13ers");
		return mv;
	}
	
	@RequestMapping(path={"loc-coAll"})
	public ModelAndView coAll(Model model) {
		ModelAndView mv = new ModelAndView();
		addLinkingTables(mv);
		mv.addObject("list", pointDAO.findByCategoryIds(new int[] {1, 2}));
		mv.setViewName("loc_co_all");
		return mv;
	}
	
	@RequestMapping(path={"loc-user"})
	public ModelAndView userCreated() {
		ModelAndView mv = new ModelAndView();
		addLinkingTables(mv);
		mv.addObject("list", pointDAO.findUserCreated());
		mv.setViewName("loc_user");
		return mv;
	}
	
	@RequestMapping(path={"loc-remove"})
	public String removeLocation() {
		return "loc_remove";
	}
	
	@RequestMapping(path="loc-all")
	public ModelAndView getAllLocPoints() {
		ModelAndView mv = new ModelAndView();
		addLinkingTables(mv);
		mv.addObject("list", pointDAO.findAll());
		mv.setViewName("loc_all");
		return mv;
	}
	
	@RequestMapping(path="loc", method = RequestMethod.GET)
	public ModelAndView getLocPoint(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		Point point = pointDAO.findById(id);
		mv.addObject("point", point);
		addLinkingTables(mv);
		mv.addObject("category", catDAO.findById(point.getCategoryId()));
		mv.addObject("range", rangeDAO.findById(point.getRangeId()));
		mv.setViewName("loc");
		return mv;
	}
	
	@RequestMapping(path="loc-add", method = RequestMethod.GET)
	public ModelAndView addLocationBegin() {
		ModelAndView mv = new ModelAndView();
		addLinkingTables(mv);
		mv.setViewName("loc_add");
		return mv;
	}
	
	@RequestMapping(path="remove-location.do")
	public ModelAndView removeLocation(@RequestParam("id") int id) {
		Point point = pointDAO.findById(id);
		Point backup = new Point();
		pointDAO.copyPoint(point, backup);
		ModelAndView mv = new ModelAndView();
		mv.addObject("category", catDAO.findById(point.getCategoryId()));
		mv.addObject("range", rangeDAO.findById(point.getRangeId()));
		pointDAO.removePoint(point);
		mv.addObject("backup", backup);
		mv.setViewName("loc_removed");
		return mv;
	}
	
	private void addLinkingTables(ModelAndView mv) {
		mv.addObject("categories", catDAO.findAll());
		mv.addObject("ranges", rangeDAO.findAll());
	}
	
}
