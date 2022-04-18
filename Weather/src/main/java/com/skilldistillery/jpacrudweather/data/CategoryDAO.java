package com.skilldistillery.jpacrudweather.data;

import java.util.List;

import com.skilldistillery.jpacrudweather.entities.Category;

public interface CategoryDAO {
	
	public List<Category> findAll();

}
