package ar.com.plug.examen.controllers;

import ar.com.plug.examen.helpers.ResponseHelper;
import ar.com.plug.examen.models.Transaction;
import ar.com.plug.examen.service.TransactionService;
import ar.com.plug.examen.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/transactions",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionServiceImpl transactionServiceImpl) {
        this.transactionService = transactionServiceImpl;
    }

    @GetMapping
    public List<Transaction> showTransaction() {
        return transactionService.getAllSellers();
    }

    @PostMapping
    public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction) {
        int response = transactionService.addingTransaction(transaction);
        return ResponseHelper.getHttpStatusResponse(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> updateStateTransaction(@PathVariable("id") Long id) {
        int result = transactionService.updateTransactionState(id, "APPROVED");
        return ResponseHelper.getHttpStatusResponse(result);
    }
}
