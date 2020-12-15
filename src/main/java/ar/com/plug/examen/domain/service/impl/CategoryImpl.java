package ar.com.plug.examen.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.plug.examen.domain.dao.ICategoryDao;
import ar.com.plug.examen.domain.entities.CategoryEntity;
import ar.com.plug.examen.domain.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService {

	@Autowired
	private ICategoryDao categoryDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<CategoryEntity> findAll() {
		return (List<CategoryEntity>) categoryDao.findAll() ;
	}

	@Override
	@Transactional(readOnly = true)
	public CategoryEntity findById(Long id) {
		return categoryDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CategoryEntity save(CategoryEntity category) {
		return categoryDao.save(category);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		categoryDao.deleteById(id);
	}

}
