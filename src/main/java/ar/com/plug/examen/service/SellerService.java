package ar.com.plug.examen.service;

import ar.com.plug.examen.entities.SellerEntity;

import java.util.List;

public interface SellerService {
	int addSeller(SellerEntity sellerEntity);
	int updateSeller(SellerEntity sellerEntity);
	int deleteSeller(Long id);
	List<SellerEntity> getAllSellers();
}