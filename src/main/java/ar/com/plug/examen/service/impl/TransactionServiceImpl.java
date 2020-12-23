package ar.com.plug.examen.service.impl;

/*
 * Service Class in charge of manage the business operations
 */

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.plug.examen.entities.TransactionEntity;
import ar.com.plug.examen.models.Transaction;
import ar.com.plug.examen.repositories.ProductRepository;
import ar.com.plug.examen.repositories.TransactionRepository;
import ar.com.plug.examen.service.TransactionService;
import ar.com.plug.examen.transformers.EntityTransformer;
import ar.com.plug.examen.transformers.ModelTransformer;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, ProductRepository productRepository) {
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
    }

    @Override
	public TransactionEntity addTransaction(Transaction transaction) {
        TransactionEntity transactionEntity = ModelTransformer.toTransactionEntity(transaction);
        try {
        	log.info("createTransaction processed correctly");
        	transactionRepository.save(transactionEntity);
            
            updateProductQuantity(transaction);
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
        }
		return null;
    }

    @Override
	public void updateProductQuantity(Transaction transaction) {
        TransactionEntity transactionEntity = ModelTransformer.toTransactionEntity(transaction);
        try {
            log.info("updateProductQuantity processed correctly");
            transactionEntity.getTransactionsProducts().forEach(t ->
                productRepository.updateQuantity(t.getIdProduct(), t.getQuantity())
            );
           
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
           
        }
    }

/*
 *     @Override
 *
*	public void updateTransactionState(Long id, String stateOrder) {
 *       return transactionRepository.updateStateOrder(stateOrder, id);
 *}
 */   

    @Override
	public List<Transaction> getAllSellers() {
        List<TransactionEntity> transactionEntities = transactionRepository.findAll();
        log.info("getAllSellers processed correctly");
        return transactionEntities.stream()
                .map(EntityTransformer::toTransaction)
                .collect(Collectors.toList());
    }

	@Override
	public void updateTransactionState(Long id, String stateOrder) {
		// TODO Auto-generated method stub
		
	}

}
