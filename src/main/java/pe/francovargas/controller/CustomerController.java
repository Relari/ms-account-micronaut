package pe.francovargas.controller;

import io.micronaut.http.annotation.*;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import pe.francovargas.model.api.CustomerRequest;
import pe.francovargas.model.api.CustomerResponse;
import pe.francovargas.model.domain.Customer;
import pe.francovargas.service.CustomerService;

@Controller(value = "/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService service;


    @Get
    public Observable<CustomerResponse> createCustomer() {
        return service.findAll()
                .map(CustomerResponse::new);
    }

    @Post
    public Completable createCustomer(@Body CustomerRequest request) {
        return Single.fromCallable(() -> new Customer(request))
                .flatMapCompletable(service::save);
    }

    @Put("/{idCustomer}")
    public Completable updateCustomer(@PathVariable Integer idCustomer, @Body CustomerRequest request) {
        return service.update(idCustomer, request.getFullName());
    }

    @Get("/{idCustomer}")
    public Single<CustomerResponse> updateCustomer(@PathVariable Integer idCustomer) {
        return service.findById(idCustomer)
                .map(CustomerResponse::new);
    }

}
