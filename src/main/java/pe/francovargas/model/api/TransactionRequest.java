package pe.francovargas.model.api;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Serdeable
@Getter
@Setter
public class TransactionRequest {

    @NotNull
    private Integer idAccount;

    @NotNull
    private Double amount;

    @Pattern(regexp = "^(deposit|withdrawal)$", message = "Type must be either DEPOSIT or WITHDRAWAL")
    private String type;

}
