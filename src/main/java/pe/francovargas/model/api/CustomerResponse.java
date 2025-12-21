package pe.francovargas.model.api;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import pe.francovargas.model.domain.Customer;

@Serdeable
@Getter
public class CustomerResponse {

    private final Integer idCustomer;
    private final String fullName;

    public CustomerResponse(Customer customer) {
        this.idCustomer = customer.getIdCustomer();
        this.fullName = customer.getFullName();
    }

}
