package ar.com.plug.examen.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "T_SELLER")
public class SellerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(mappedBy = "sellerFK", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TransactionEntity> transactions;
    private String name;
    private String lastname;
    private String businessName;
    private String address;
    private String telephone;
    private String cuit;
    private String cuil;
}
