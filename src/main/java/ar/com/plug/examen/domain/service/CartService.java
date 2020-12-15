package ar.com.plug.examen.domain.service;

import java.util.List;

import ar.com.plug.examen.domain.entities.CartEntity;


public interface CartService {

	public List<CartEntity> findAll();
	
	public CartEntity findById(Long id);
	
	public CartEntity save(CartEntity cart);
	
	public void delete(Long id);
}
