package ar.com.plug.examen.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.plug.examen.domain.dao.IProductDao;
import ar.com.plug.examen.domain.entities.ProductEntity;
import ar.com.plug.examen.domain.service.IProductService;

@Service
public class ProductImpl implements IProductService {

	@Autowired
	private IProductDao productDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductEntity> findAll() {
		return (List<ProductEntity>) productDao.findAll() ;
	}

	@Override
	@Transactional(readOnly = true)
	public ProductEntity findById(Long id) {
		return productDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public ProductEntity save(ProductEntity product) {
		return productDao.save(product);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		productDao.deleteById(id);
	}

}
