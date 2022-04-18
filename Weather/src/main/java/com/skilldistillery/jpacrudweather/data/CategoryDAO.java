package com.skilldistillery.jpacrudweather.data;

import java.util.Map;

import com.skilldistillery.jpacrudweather.entities.Category;

public interface CategoryDAO {
	
	public Category findById(int id); 
	public Map<Integer, Category> findAll();
	public int addCategory(Category category);
	public Category updateCategory(int id, Category category);
	public void removeCategory(Category category);

}
