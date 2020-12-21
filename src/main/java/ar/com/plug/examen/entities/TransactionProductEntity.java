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
@Table(name = "transaction_product")
public class TransactionProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="value",columnDefinition = "long")
    private long value;
    @Column(name="id_product",columnDefinition = "long")
    private long idProduct;
    @Column(name="quantity",columnDefinition = "long")
    private long quantity;
}
