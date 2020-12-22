package ar.com.plug.examen.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Table(name = "T_TRANSACTION")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "P_ID")
    private long id;
    @Column(name="STATE_ORDER")
    private String stateOrder;
    @Column(name="DATE_ORDER")
    private String dateOrder;
    @Column(name="P_ID_CLIENT")
    private long idClient;
    @Column(name="P_ID_SELLER")
    private long idSeller;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "transactionEntity")
    private List<TransactionProductEntity> transactionsProducts;
}
