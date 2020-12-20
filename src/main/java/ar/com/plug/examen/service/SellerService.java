package ar.com.plug.examen.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.plug.examen.entities.Seller;
import ar.com.plug.examen.repositories.SellerRepository;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;
    Logger logger = LoggerFactory.getLogger(SellerService.class);

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public int addSeller(Seller seller) {
        try {
        	sellerRepository.save(seller);
            logger.info("insertSeller processed correctly");
            return 1;
        } catch (Exception e) {
            logger.error("Error "+e.getMessage());
            return 0;
        }
    }

    public int updateSeller(Seller seller) {
        try {
        	sellerRepository.save(seller);
            logger.info("updateSeller processed correctly");
            return 1;
        } catch (Exception e) {
            logger.error("Error "+e.getMessage());
            return 0;
        }
    }

    public int deleteSeller (Long id){
        try {
        	sellerRepository.deleteById(id);
            logger.info("deleteSeller processed correctly");
            return 1;
        } catch (Exception e) {
            logger.error("Error "+e.getMessage());
            return 0;
        }
    }

    public List<Seller> getAllSellers() {
        List<Seller> seller = sellerRepository.findAll();
        logger.info("getAllSellers processed correctly");
        return seller;
    }
}
