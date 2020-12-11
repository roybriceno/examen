package ar.com.plug.examen.domain.entities;

import lombok.Data;

@Data
public class SellerEntity {
    private long id;
    private String name;
    private String lastname;
    private String businessName;
    private String address;
    private String telephone;
    private String cuit;
    private String cuil;
}
