package ar.com.plug.examen.domain.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "T_TRANSACTION")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private ClientEntity clientFK;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private SellerEntity sellerFK;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private CartEntity cartFK;
    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private TransactionStatusEntity transactionStatusFK;
    private BigDecimal amount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
