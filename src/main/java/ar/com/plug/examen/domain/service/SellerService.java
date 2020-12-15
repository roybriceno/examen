package ar.com.plug.examen.domain.service;

import java.util.List;

import ar.com.plug.examen.domain.entities.SellerEntity;

public interface SellerService {

	public List<SellerEntity> findAll();
	
	public SellerEntity findById(Long id);
	
	public SellerEntity save(SellerEntity seller);
	
	public void delete(Long id);
}
