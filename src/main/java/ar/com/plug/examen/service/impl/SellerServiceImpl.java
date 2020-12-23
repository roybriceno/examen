package ar.com.plug.examen.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.plug.examen.entities.SellerEntity;
import ar.com.plug.examen.models.Seller;
import ar.com.plug.examen.repositories.SellerRepository;
import ar.com.plug.examen.service.SellerService;
import ar.com.plug.examen.transformers.EntityTransformer;
import ar.com.plug.examen.transformers.ModelTransformer;
import lombok.extern.log4j.Log4j2;

/*
 * Service Class in charge of manage the business operations
 */

@Log4j2
@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
	public SellerEntity addSeller(Seller seller) {
        SellerEntity sellerEntity = ModelTransformer.toSellerEntity(seller);
        try {
        	log.info("insertSeller processed correctly");
        	return sellerRepository.save(sellerEntity);
            
            
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return null;
        }
    }

    @Override
	public SellerEntity updateSeller(Seller seller) {
        SellerEntity sellerEntity = ModelTransformer.toSellerEntity(seller);
        try {
        	log.info("updateSeller processed correctly");
        	return sellerRepository.save(sellerEntity);
            
            
        } catch (Exception e) {
        	log.error("Error " + e.getMessage());
        	return null;
        	
            
        }
    }

    @Override
	public void deleteSeller(Long id) {
        try {
        	log.info("deleteSeller processed correctly");
        	sellerRepository.deleteById(id);
            
            
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            
        }
    }

    @Override
	public List<Seller> getAllSellers() {
        List<SellerEntity> sellerEntities = sellerRepository.findAll();
        log.info("getAllSellers processed correctly");
        return sellerEntities.stream()
                .map(EntityTransformer::toSeller)
                .collect(Collectors.toList());
    }
}
