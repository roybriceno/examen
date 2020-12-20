package ar.com.plug.examen.service;

import ar.com.plug.examen.entities.Seller;
import ar.com.plug.examen.repositories.SellerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public int addSeller(Seller seller) {
        try {
            sellerRepository.save(seller);
            log.info("insertSeller processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    public int updateSeller(Seller seller) {
        try {
            sellerRepository.save(seller);
            log.info("updateSeller processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    public int deleteSeller(Long id) {
        try {
            sellerRepository.deleteById(id);
            log.info("deleteSeller processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    public List<Seller> getAllSellers() {
        List<Seller> seller = sellerRepository.findAll();
        log.info("getAllSellers processed correctly");
        return seller;
    }
}
