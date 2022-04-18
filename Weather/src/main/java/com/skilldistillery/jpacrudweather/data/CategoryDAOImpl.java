package com.skilldistillery.jpacrudweather.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpacrudweather.entities.Category;

@Service
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Category> findAll() {
		String query = "SELECT c FROM Category c";
		List<Category> results = em.createQuery(query, Category.class).getResultList();
		return results;
	}

}
