package ar.com.plug.examen.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Table(name = "T_TRANSACTION_PRODUCT")
public class TransactionProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "P_ID")
    private long id;
    @Column(name="VALUE")
    private long value;
    @Column(name="P_ID_PRODUCT")
    private long idProduct;
    @Column(name="QUANTITY")
    private long quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transactionentity_id")
    private TransactionEntity transactionEntity;
}
