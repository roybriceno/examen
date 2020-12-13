package ar.com.plug.examen.domain.service;

import java.util.List;

import ar.com.plug.examen.domain.entities.ProductEntity;

public interface IProductService {

	public List<ProductEntity> findAll();
	
	public ProductEntity findById(Long id);
	
	public ProductEntity save(ProductEntity product);
	
	public void delete(Long id);
}
