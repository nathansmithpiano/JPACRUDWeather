package com.skilldistillery.jpacrudweather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LinkController {
	
	@RequestMapping(path= {"/", "index"})
	public String home() {
		return "index";
	}
	
	@RequestMapping(path={"loc-co14ers"})
	public String co14ers() {
		return "loc_co_14ers";
	}
	
	@RequestMapping(path={"loc-co13ers"})
	public String co13ers() {
		return "loc_co_13ers";
	}
	
	@RequestMapping(path={"loc-coAll"})
	public String coAll() {
		return "loc_co_all";
	}
	
	@RequestMapping(path={"loc-other"})
	public String other() {
		return "loc_other";
	}
	
	@RequestMapping(path={"loc-user"})
	public String userCreated() {
		return "loc_user";
	}
	
	@RequestMapping(path={"loc-remove"})
	public String removeLocation() {
		return "loc_remove";
	}
	
}
