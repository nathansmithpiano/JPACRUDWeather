package com.skilldistillery.jpacrudweather.data;

import java.util.Map;

import com.skilldistillery.jpacrudweather.entities.Range;

public interface RangeDAO {
	
	public Range findById(int id); 
	public Map<Integer, Range> findAll();
	public int addRange(Range range);
	public Range updateRange(int id, Range range);
	public void removeRange(Range range);

}
