package pe.francovargas.dao.mapper;

import pe.francovargas.dao.db.entity.AccountEntity;
import pe.francovargas.dao.db.entity.CustomerEntity;
import pe.francovargas.model.domain.Account;
import pe.francovargas.model.domain.Customer;

public class AccountMapper {

    private AccountMapper() {}

    public static Account mapAccount(AccountEntity accountEntity) {
        return Account.builder()
                .idAccount(accountEntity.getIdAccount())
                .totalAmount(accountEntity.getTotalAmount())
                .customer(new Customer(
                        accountEntity.getCustomer().getIdCustomer(),
                        accountEntity.getCustomer().getFullName())
                )
                .build();
    }

    public static AccountEntity mapAccountEntity(Account account) {
        return AccountEntity.builder()
                .idAccount(account.getIdAccount())
                .totalAmount(account.getTotalAmount())
                .customer(new CustomerEntity(
                        account.getCustomer().getIdCustomer(),
                        account.getCustomer().getFullName())
                )
                .build();
    }

}
