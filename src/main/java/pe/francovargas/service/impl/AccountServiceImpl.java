package pe.francovargas.service.impl;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import pe.francovargas.dao.AccountDao;
import pe.francovargas.dao.CustomerDao;
import pe.francovargas.model.domain.Account;
import pe.francovargas.model.domain.Transaction;
import pe.francovargas.service.AccountService;

@Singleton
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

	private final AccountDao accountDao;
	private final CustomerDao customerDao;
	
	@Override
	public Observable<Account> findAll() {
		return accountDao.findAll();
	}

	@Override
	public Single<Account> findById(Integer id) {
		return accountDao.findById(id);
	}

	@Override
	public Completable save(Account account) {
		return customerDao.findById(account.getCustomer().getIdCustomer())
				.flatMapCompletable(customer -> {
					account.setCustomer(customer);
					return accountDao.save(account);
				});
	}

	@Override
	public Completable saveTransaction(Transaction transaction) {
		return accountDao.findById(transaction.getAccountId())
				.map(account -> {
					double newAmount = switch (transaction.getType()) {
                        case "deposit" -> account.getTotalAmount() + transaction.getAmount();
                        case "withdrawal" -> account.getTotalAmount() - transaction.getAmount();
                        default -> 0;
                    };

                    account.setTotalAmount(newAmount);
					return account;
				}).flatMapCompletable(accountDao::update);
	}

}
