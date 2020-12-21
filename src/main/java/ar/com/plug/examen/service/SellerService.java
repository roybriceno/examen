package ar.com.plug.examen.service;

import ar.com.plug.examen.models.Seller;

import java.util.List;

public interface SellerService {
	int addSeller(Seller seller);
	int updateSeller(Seller seller);
	int deleteSeller(Long id);
	List<Seller> getAllSellers();
}