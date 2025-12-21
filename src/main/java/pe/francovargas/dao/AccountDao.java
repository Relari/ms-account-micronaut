package pe.francovargas.dao;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import pe.francovargas.model.domain.Account;

public interface AccountDao {

    Observable<Account> findAll();

    Completable save(Account accountEntity);

    Single<Account> findById(Integer id);

}
