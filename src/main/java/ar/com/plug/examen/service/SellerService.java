package ar.com.plug.examen.service;

import java.util.List;

/*
 * Service Class in charge of manage the business operations
 */

import ar.com.plug.examen.entities.SellerEntity;
import ar.com.plug.examen.models.Seller;

public interface SellerService {
	SellerEntity addSeller(Seller seller);
	SellerEntity updateSeller(Seller seller);
	void deleteSeller(Long id);
	List<Seller> getAllSellers();
}