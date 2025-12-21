package pe.francovargas.dao.impl;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import pe.francovargas.dao.CustomerDao;
import pe.francovargas.dao.db.entity.CustomerEntity;
import pe.francovargas.dao.db.repository.CustomerRepository;
import pe.francovargas.model.domain.Customer;

@Singleton
@AllArgsConstructor
public class CustomerDaoImpl implements CustomerDao {

    private final CustomerRepository customerRepository;

    @Override
    public Observable<Customer> findAll() {
        return Observable.fromIterable(customerRepository.findAll())
                .subscribeOn(Schedulers.io())
                .map(customerEntity -> new Customer(
                        customerEntity.getIdCustomer(),
                        customerEntity.getFullName()
                ));
    }

    @Override
    public Completable save(Customer customer) {
        return Single.fromCallable(() -> new CustomerEntity(customer.getIdCustomer(), customer.getFullName()))
                .map(customerRepository::save)
                .subscribeOn(Schedulers.io())
                .ignoreElement();
    }

    @Override
    public Completable update(Customer customer) {
        return Single.fromCallable(() -> new CustomerEntity(customer.getIdCustomer(), customer.getFullName()))
                .map(customerRepository::update)
                .subscribeOn(Schedulers.io())
                .ignoreElement();
    }

    @Override
    public Single<Customer> findById(Integer id) {
        return Single.fromCallable(() ->
                        customerRepository.findById(id).orElse(null))
                .subscribeOn(Schedulers.io())
                .map(customerEntity -> new Customer(
                        customerEntity.getIdCustomer(),
                        customerEntity.getFullName()
                ));
    }
}
