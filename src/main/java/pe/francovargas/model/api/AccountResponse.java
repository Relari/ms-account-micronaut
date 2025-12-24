package pe.francovargas.model.api;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import pe.francovargas.model.domain.Account;

@Serdeable
@Getter
public class AccountResponse {

    private final Integer idAccount;
    private final double totalAmount;
    private final String currency;
    private final CustomerResponse customer;

    public AccountResponse(Account account) {
        this.idAccount = account.getIdAccount();
        this.totalAmount = account.getTotalAmount();
        this.currency = account.getCurrency().name();
        this.customer = new CustomerResponse(account.getCustomer());
    }

}
