package ar.com.plug.examen.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class TransactionProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "long")
    private  Long value;
    @Column(columnDefinition = "long")
    private  Long id_product;
    @Column(columnDefinition = "long")
    private  Long quantity;

    public TransactionProducts(@JsonProperty("value") Long value,
                                @JsonProperty("id_product") Long id_product,
                                @JsonProperty("quantity")Long quantity) {

        this.value = value;
        this.id_product = id_product;
        this.quantity = quantity;

    }

    public TransactionProducts() {

    }
}
