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
@Table(name = "T_CLIENT")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "P_ID")
    private long id;
    @Column(name="NAME")
    private String name;
    @Column(name="last_name",columnDefinition = "varchar(255)")
    private String lastName;
    @Column(name="document",columnDefinition = "integer")
    private long document;
    @Column(name="phone",columnDefinition = "integer")
    private long phone;
    @Column(name="adress",columnDefinition = "varchar(255)")
    private String address;
}
