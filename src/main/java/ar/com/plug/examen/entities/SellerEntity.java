package ar.com.plug.examen.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_SELLER")
public class SellerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "P_ID")
    private long id;
    @Column(name="NAME")
    private String name;
    @Column(name="LAST_NAME")
    private String lastname;
    @Column(name="DOCUMENT")
    private long document;
    @Column(name="PHONE")
    private long phone;
}
