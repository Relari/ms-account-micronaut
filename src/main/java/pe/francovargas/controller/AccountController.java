package pe.francovargas.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import pe.francovargas.model.api.AccountResponse;
import pe.francovargas.service.AccountService;


@Controller(value = "/v1/accounts")
@AllArgsConstructor
public class AccountController {

	private final AccountService service;

	@Get
	public Observable<AccountResponse> findAll() {
		return service.findAll()
				.map(AccountResponse::new);
	}

	@Get("/{id}")
	public Single<AccountResponse> findById(@PathVariable Integer id) {
		return service.findById(id)
				.map(AccountResponse::new);
	}

}
