package ar.com.plug.examen.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ar.com.plug.examen.domain.entities.CartEntity;
import ar.com.plug.examen.domain.entities.ClientEntity;
import ar.com.plug.examen.domain.entities.SellerEntity;
import ar.com.plug.examen.domain.entities.TransactionStatusEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Transaction {
    private long id;
    private ClientEntity clientFK;
    private SellerEntity sellerFK;
    private CartEntity cartFK;
    private TransactionStatusEntity transactionStatusFK;
    private BigDecimal amount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}


