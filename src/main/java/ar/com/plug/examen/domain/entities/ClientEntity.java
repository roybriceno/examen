package ar.com.plug.examen.domain.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientEntity {
    private long id;
    private String name;
    private String lastname;
    private String dni;
    private String address;
    private String telephone;
    private LocalDate birthday;
}
