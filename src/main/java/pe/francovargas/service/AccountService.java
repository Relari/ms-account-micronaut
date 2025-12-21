package pe.francovargas.service;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import pe.francovargas.model.domain.Account;
import pe.francovargas.model.domain.Transaction;

public interface AccountService {

	Observable<Account> findAll();
	Single<Account> findById (Integer id );
	Completable save (Transaction event);
	
}
