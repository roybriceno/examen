package ar.com.plug.examen.controllers;

import ar.com.plug.examen.entities.TransactionEntity;
import ar.com.plug.examen.service.impl.TransactionServiceImpl;
import ar.com.plug.examen.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/transactions")

public class TransactionController {

    private final TransactionServiceImpl transactionServiceImpl;

    @Autowired
    public TransactionController(TransactionServiceImpl transactionServiceImpl) {
        this.transactionServiceImpl = transactionServiceImpl;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addTransaction(@RequestBody TransactionEntity transactionEntity) {
        int response = transactionServiceImpl.addingTransaction(transactionEntity);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @GetMapping
    public List<TransactionEntity> showTransaction() {
        return transactionServiceImpl.getAllSellers();
    }


    @GetMapping(path = "{id}")
    public ResponseEntity<?> updateStateTransaction(@PathVariable("id") Long id) {
        int result = transactionServiceImpl.updateTransactionState(id, "APPROVED");
        return MessageResponse.getIntegerResponseEntity(result);
    }
}
