package com.skilldistillery.jpacrudweather.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpacrudweather.entities.Range;

@Service
@Transactional
public class RangeDAOImpl implements RangeDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Range findById(int id) {
		return em.find(Range.class, id);
	}

	@Override
	public Map<Integer, Range> findAll() {
		String query = "SELECT r FROM Range r";
		List<Range> list = em.createQuery(query, Range.class).getResultList();
		Map<Integer, Range> results = new HashMap<Integer, Range>();
		for (Range range : list) {
			results.put(range.getId(), range);
		}
		return results;
	}

	@Override
	public int addRange(Range range) {
		em.persist(range);
		em.flush();
		return range.getId();
	}

	@Override
	public Range updateRange(int id, Range range) {
		Range mRange = em.find(Range.class, id);
		mRange.setName(range.getName());
		em.flush();
		return mRange;
	}

	@Override
	public void removeRange(Range range) {
		em.remove(range);
		em.flush();
	}

}
