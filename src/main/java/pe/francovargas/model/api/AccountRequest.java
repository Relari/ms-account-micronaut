package pe.francovargas.model.api;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Serdeable
@Getter
@Setter
public class AccountRequest {

    @NotNull
    private double amount;

    @Pattern(regexp = "^(USD|PEN)$", message = "Currency must be either USD or PEN")
    private String currency;
    private Integer idCustomer;

}
