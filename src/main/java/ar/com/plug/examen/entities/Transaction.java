package ar.com.plug.examen.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "varchar(255)")
    private String state_order;
    @Column(columnDefinition = "varchar(255)")
    private String dateOrder;
    @Column(columnDefinition = "long")
    private Long idClient;
    @Column(columnDefinition = "long")
    private Long idSeller;
    @OneToMany(targetEntity = TransactionProducts.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cp_fk", referencedColumnName = "id")
    private List<TransactionProducts> transactionsProducts;

    public Transaction(@JsonProperty("state_order") State state_order,
                       @JsonProperty("dateOrder") String dateOrder,
                       @JsonProperty("idClient") Long idClient,
                       @JsonProperty("idSeller") Long idSeller,
                       @JsonProperty("transactionProducts") List<TransactionProducts> transactionProducts) {
        this.state_order = state_order.toString();
        this.dateOrder = dateOrder;
        this.idClient = idClient;
        this.idSeller = idSeller;
        this.transactionsProducts = transactionProducts;
    }

    public Transaction() {

    }

    public enum State {
        INPROCESS,
        APPROVED,
        REJECTED
    }
}
