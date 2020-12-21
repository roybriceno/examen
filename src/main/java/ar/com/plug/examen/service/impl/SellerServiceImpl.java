package ar.com.plug.examen.service.impl;

import ar.com.plug.examen.entities.SellerEntity;
import ar.com.plug.examen.repositories.SellerRepository;
import ar.com.plug.examen.service.SellerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
	public int addSeller(SellerEntity sellerEntity) {
        try {
            sellerRepository.save(sellerEntity);
            log.info("insertSeller processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    @Override
	public int updateSeller(SellerEntity sellerEntity) {
        try {
            sellerRepository.save(sellerEntity);
            log.info("updateSeller processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    @Override
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

    @Override
	public List<SellerEntity> getAllSellers() {
        List<SellerEntity> sellerEntity = sellerRepository.findAll();
        log.info("getAllSellers processed correctly");
        return sellerEntity;
    }
}
