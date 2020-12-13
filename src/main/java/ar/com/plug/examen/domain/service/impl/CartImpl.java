package ar.com.plug.examen.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.plug.examen.domain.dao.ICartDao;
import ar.com.plug.examen.domain.entities.CartEntity;
import ar.com.plug.examen.domain.service.ICartService;

@Service
public class CartImpl implements ICartService {

	@Autowired
	private ICartDao cartDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<CartEntity> findAll() {
		return (List<CartEntity>) cartDao.findAll() ;
	}

	@Override
	@Transactional(readOnly = true)
	public CartEntity findById(Long id) {
		return cartDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CartEntity save(CartEntity cart) {
		return cartDao.save(cart);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		cartDao.deleteById(id);
	}

}
