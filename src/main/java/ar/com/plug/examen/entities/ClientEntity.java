package ar.com.plug.examen.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "P_ID")
    private long id;
    @Column(name="NAME")
    private String name;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="DOCUMENT")
    private long document;
    @Column(name="PHONE")
    private long phone;
    @Column(name="ADDRESS")
    private String address;
}
