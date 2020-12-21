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
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="state_order",columnDefinition = "varchar(255)")
    private String stateOrder;
    @Column(name="date_order",columnDefinition = "varchar(255)")
    private String dateOrder;
    @Column(name="id_client",columnDefinition = "long")
    private long idClient;
    @Column(name="id_seller",columnDefinition = "long")
    private long idSeller;
    @OneToMany(targetEntity = TransactionProductEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk", referencedColumnName = "id")
    private List<TransactionProductEntity> transactionsProducts;
}
