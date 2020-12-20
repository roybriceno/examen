package ar.com.plug.examen.controllers;

import ar.com.plug.examen.entities.Transaction;
import ar.com.plug.examen.service.TransactionService;
import ar.com.plug.examen.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/transactions")

public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction) {
        int response = transactionService.addingTransaction(transaction);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @GetMapping
    public List<Transaction> showTransaction() {
        return transactionService.getAllSellers();
    }


    @GetMapping(path = "{id}")
    public ResponseEntity<?> updateStateTransaction(@PathVariable("id") Long id) {
        int result = transactionService.updateTransactionState(id, "APPROVED");
        return MessageResponse.getIntegerResponseEntity(result);
    }
}
