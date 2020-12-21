package ar.com.plug.examen.service.impl;

import ar.com.plug.examen.entities.SellerEntity;
import ar.com.plug.examen.models.Seller;
import ar.com.plug.examen.repositories.SellerRepository;
import ar.com.plug.examen.service.SellerService;
import ar.com.plug.examen.transformers.EntityTransformer;
import ar.com.plug.examen.transformers.ModelTransformer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class SellerServiceImpl implements SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
	public int addSeller(Seller seller) {
        SellerEntity sellerEntity = ModelTransformer.toSellerEntity(seller);
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
	public int updateSeller(Seller seller) {
        SellerEntity sellerEntity = ModelTransformer.toSellerEntity(seller);
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
	public List<Seller> getAllSellers() {
        List<SellerEntity> sellerEntities = sellerRepository.findAll();
        log.info("getAllSellers processed correctly");
        return sellerEntities.stream()
                .map(EntityTransformer::toSeller)
                .collect(Collectors.toList());
    }
}
