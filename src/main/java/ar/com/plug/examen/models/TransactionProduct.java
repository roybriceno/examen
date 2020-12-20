package ar.com.plug.examen.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("transaction_product")
public class TransactionProduct {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("value")
    private Long value;
    @JsonProperty("id_product")
    private Long idProduct;
    @JsonProperty("quantity")
    private Long quantity;
}
