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
@Table(name = "seller")
public class SellerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name",columnDefinition = "varchar(255)")
    private String name;
    @Column(name="lastname",columnDefinition = "varchar(255)")
    private String lastname;
    @Column(name="document",columnDefinition = "long")
    private long document;
    @Column(name="phone",columnDefinition = "long")
    private long phone;
    @Column(name="state",columnDefinition = "boolean")
    private boolean state;
}
