package ar.com.plug.examen.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.plug.examen.domain.dao.ISellerDao;
import ar.com.plug.examen.domain.entities.SellerEntity;
import ar.com.plug.examen.domain.service.SellerService;

@Service
public class SellerImpl implements SellerService {

	@Autowired
	private ISellerDao sellerDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<SellerEntity> findAll() {
		return (List<SellerEntity>) sellerDao.findAll() ;
	}

	@Override
	@Transactional(readOnly = true)
	public SellerEntity findById(Long id) {
		return sellerDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public SellerEntity save(SellerEntity seller) {
		return sellerDao.save(seller);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		sellerDao.deleteById(id);
	}

}
