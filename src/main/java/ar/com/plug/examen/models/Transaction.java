package ar.com.plug.examen.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("transaction")
public class Transaction {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("state_order")
    private String stateOrder;
    @JsonProperty("date_order")
    private String dateOrder;
    @JsonProperty("id_client")
    private Long idClient;
    @JsonProperty("id_seller")
    private Long idSeller;
    @JsonProperty("transaction_products")
    private List<TransactionProduct> transactionProducts;
}
