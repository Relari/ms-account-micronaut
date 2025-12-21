package pe.francovargas.model.api;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

@Serdeable
@Getter
@Setter
public class AccountRequest {

    private double amount;
    private Integer idCustomer;

}
