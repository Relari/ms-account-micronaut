package pe.francovargas.model.api;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Serdeable
@Getter
@Setter
public class CustomerRequest {

    @NotNull
    @NotBlank
    private String documentNumber;
    @Pattern(regexp = "^(DNI|CE|PASSPORT)$", message = "Document type must be either DNI, CE, or PASSPORT")
    private String documentType;
    @NotNull
    @NotBlank
    private String fullName;

}
