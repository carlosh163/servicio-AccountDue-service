package com.springboot.appbanco.service;

import com.springboot.appbanco.model.AccountDue;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountDueService {

	public Flux<AccountDue> findAll();

	public Mono<AccountDue> findById(String id);

	public Mono<AccountDue> update(AccountDue perso, String id);

	public Mono<Void> delete(String id);

	public Mono<AccountDue> create(AccountDue accD);

	public Flux<AccountDue> findByDocumentNumber(String doc);
}
