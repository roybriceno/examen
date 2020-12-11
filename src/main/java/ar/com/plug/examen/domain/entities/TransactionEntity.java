package ar.com.plug.examen.domain.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionEntity {
    private long id;
    private long clientFK;
    private long sellerFK;
    private long cartFK;
    private long transactionStatusFK;
    private BigDecimal amount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
