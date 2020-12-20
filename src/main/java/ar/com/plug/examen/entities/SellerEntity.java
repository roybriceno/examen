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
public class SellerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(columnDefinition = "varchar(255)")
    private String name;
    @Column(columnDefinition = "varchar(255)")
    private String lastname;
    @Column(columnDefinition = "long")
    private long document;
    @Column(columnDefinition = "long")
    private long phone;
    @Column(columnDefinition = "boolean")
    private boolean state;
}
