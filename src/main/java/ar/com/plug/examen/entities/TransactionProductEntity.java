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
public class TransactionProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(columnDefinition = "long")
    private long value;
    @Column(columnDefinition = "long")
    private long idProduct;
    @Column(columnDefinition = "long")
    private long quantity;
}
