package pe.francovargas.model.domain;

import lombok.*;
import pe.francovargas.model.api.AccountRequest;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Integer idAccount;
    private double totalAmount;
    private Currency currency;
    private Customer customer;

    public Account(AccountRequest request, Integer idCustomer) {
        this.totalAmount = request.getAmount();
        this.currency = Currency.valueOf(request.getCurrency());
        this.customer = new Customer(idCustomer);
    }

}
