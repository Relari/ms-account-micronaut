package pe.francovargas.service.impl;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import pe.francovargas.dao.CustomerDao;
import pe.francovargas.model.domain.Customer;
import pe.francovargas.service.CustomerService;

@Singleton
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDao customerDao;

    @Override
    public Completable save(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Completable update(Integer idCustomer, String fullName) {
        return customerDao.findById(idCustomer)
                .flatMapCompletable(customer -> {
                    customer.setFullName(fullName);
                    return customerDao.update(customer);
                });
    }

    @Override
    public Observable<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Single<Customer> findById(Integer idCustomer) {
        return customerDao.findById(idCustomer);
    }
}
