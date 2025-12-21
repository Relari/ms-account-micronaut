package pe.francovargas.service;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import pe.francovargas.model.domain.Customer;

public interface CustomerService {

    Completable save(String fullName);
    Completable update(Integer idCustomer, String fullName);
    Observable<Customer> findAll();
    Single<Customer> findById(Integer idCustomer);

}
