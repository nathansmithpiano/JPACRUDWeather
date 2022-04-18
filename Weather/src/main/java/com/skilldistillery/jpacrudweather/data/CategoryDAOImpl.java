package com.skilldistillery.jpacrudweather.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Category findById(int id) {
		return em.find(Category.class, id);
	}

	@Override
	public Map<Integer, Category> findAll() {
		String query = "SELECT c FROM Category c";
		List<Category> list = em.createQuery(query, Category.class).getResultList();
		Map<Integer, Category> results = new HashMap<Integer, Category>();
		for (Category cat : list) {
			results.put(cat.getId(), cat);
		}
		return results;
	}

	@Override
	public int addCategory(Category category) {
		em.persist(category);
		em.flush();
		return category.getId();
	}

	@Override
	public Category updateCategory(int id, Category cat) {
		Category mCat = em.find(Category.class, id);
		mCat.setName(cat.getName());
		em.flush();
		return mCat;
	}

	@Override
	public void removeCategory(Category category) {
		em.remove(category);
		em.flush();
	}

}
