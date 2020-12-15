package ar.com.plug.examen.domain.service;

import java.util.List;

import ar.com.plug.examen.domain.entities.CategoryEntity;

public interface CategoryService {

	public List<CategoryEntity> findAll();
	
	public CategoryEntity findById(Long id);
	
	public CategoryEntity save(CategoryEntity category);
	
	public void delete(Long id);
}
