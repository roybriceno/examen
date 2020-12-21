package ar.com.plug.examen.service;

import java.util.List;

import ar.com.plug.examen.entities.SellerEntity;

public interface SellerServiceImpl {

	int addSeller(SellerEntity sellerEntity);
	int updateSeller(SellerEntity sellerEntity);
	int deleteSeller(Long id);
	List<SellerEntity> getAllSellers();

}