package pe.francovargas.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Integer idCustomer;
    private String fullName;

    public Customer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Customer(String fullName) {
        this.fullName = fullName;
    }

}
