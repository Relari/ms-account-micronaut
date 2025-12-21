package pe.francovargas.dao;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import pe.francovargas.model.domain.Customer;

public interface CustomerDao {

    Observable<Customer> findAll();

    Single<Customer> findById(Integer id);

    Completable save(Customer customer);

    Completable update(Customer customer);



}
