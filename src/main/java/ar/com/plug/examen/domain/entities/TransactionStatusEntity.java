package ar.com.plug.examen.domain.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "T_TRANSACTION_STATUS")
public class TransactionStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "transactionStatusFK", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<TransactionEntity> transactions;
    private String status;
}
